using Microsoft.AspNetCore.Mvc;
using Smastad.Models;
using Microsoft.AspNetCore.Http;
using System.IO;
using Microsoft.AspNetCore.Hosting;
using System.Security.Cryptography;
using Microsoft.AspNetCore.Authorization;
using System.Data;
using Microsoft.EntityFrameworkCore;

namespace Smastad.Controllers
{
    [Authorize(Roles = "Investigator")]
    public class InvestigatorController : Controller
	{

        private readonly IsmastadRepository _repository;
        private readonly IWebHostEnvironment _env;
        private readonly ApplicationDbContext _context;
        public InvestigatorController(IsmastadRepository repository, IWebHostEnvironment env, ApplicationDbContext context)
        {
            _repository = repository;
            _env = env;
            _context = context; 
        }
        
        public ViewResult CrimeInvestigator(int id)
        {
            TempData["ErrandId"] = id;
            ViewBag.ID = id;
            return View(_repository.Errandstatuses);
        }

        public ViewResult StartInvestigator()
        {
            string employeeId = User.Identity.Name; // hämta employees id

            TempData["EmployeeId"] = employeeId;
            ViewBag.EmpID = employeeId;
            return View(_repository);
        }

        // spara filer
        public async Task<IActionResult> SaveCrime(string events,string information,IFormFile loadSample,IFormFile loadImage, string status)
        {
            int errandId = int.Parse(TempData["ErrandId"].ToString());

            if (loadSample != null)
            {
                await UploadFiles(errandId, loadSample, "application/pdf", _env);
            }

            if (loadImage != null)
            {
                var contentType = loadImage.ContentType.ToLower();
                if (contentType.Contains("image/jpeg") || contentType.Contains("image/png") || contentType.Contains("image/jpg"))
                {
                    await UploadFiles(errandId, loadImage, contentType, _env);
                }
            }
            _repository.SaveEvent(errandId, events);
            _repository.SaveInfomation(errandId, information);
            _repository.SaveStatus(errandId, status);

            return RedirectToAction("CrimeInvestigator",new { id = errandId });
        }

        // ladda upp filer
        private async Task UploadFiles(int id, IFormFile file, string contentType, IWebHostEnvironment env)
        {
            try
            {
                if (file == null || file.Length == 0)
                {
                    // Felmeddelande om filen inte finns eller är tom
                    return;
                }

                if (contentType != "application/pdf" && !contentType.Contains("image/"))
                {
                    // Felmeddelande om filtypen inte stöds
                    return;
                }

                var fileName = Guid.NewGuid() + "_" + file.FileName;
                var filePath = Path.Combine(env.WebRootPath, "uploads", fileName);

                using (var stream = new FileStream(filePath, FileMode.Create))
                {
                    await file.CopyToAsync(stream);
                }

                if (contentType == "application/pdf")
                {
                    _repository.SaveSample(id, file,fileName);
                }
                else if (contentType.Contains("image/"))
                {
                    _repository.SaveImage(id, file,fileName);
                }
            }
            catch (Exception ex)
            {
                ModelState.AddModelError("", "Ogiltiga filer");
            }
        }


    }
}
