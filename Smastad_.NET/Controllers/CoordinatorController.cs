using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Smastad.Infrastructure;
using Smastad.Models;

namespace Smastad.Controllers
{
    [Authorize(Roles = "Coordinator")]
    public class CoordinatorController : Controller
	{
        private readonly IsmastadRepository _repository;
        public CoordinatorController(IsmastadRepository repository)
        {
            _repository = repository;
        }

        public ViewResult CrimeCoordinator(int id)
        {
            ViewBag.ID = id;
            TempData["ErrandId"]=id; //för att kunna visa ärenden som har blivit klickat
            return View(_repository.Departments);
        }
        public ViewResult ReportCrime()
        {
            var myErrand = HttpContext.Session.Get<Errand>("NewErrand");
            if (myErrand != null)
            {
                return View(myErrand);
            }
            else
            {
                return View();
            }
        }
        public ViewResult StartCoordinator()
        {
            return View(_repository);
        }
        public ViewResult Thanks()
        {
            var CustomErrand = HttpContext.Session.Get<Errand>("NewErrand");
            HttpContext.Session.Remove("NewErrand");
            _repository.SaveErrand(CustomErrand);
            ViewBag.Errand = CustomErrand.RefNumber;

            return View();
        }
        [HttpPost]
        public ViewResult Validate(Errand errand)
        {
            HttpContext.Session.Set<Errand>("NewErrand", errand);
            return View(errand);
        }

        public IActionResult SaveDepartment (string department)
        {
          int errandId = int.Parse(TempData["ErrandId"].ToString());
            if (department == "Välj" || department == "D00")
            {
                return RedirectToAction("CrimeCoordinator", new { id = errandId });
            }
            else
            {
                _repository.SaveDepartment(errandId, department);
                return RedirectToAction("CrimeCoordinator", new { id = errandId });
            }

        }

       
    }
}
