using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration.UserSecrets;
using Smastad.Models;
using System.Data;
using System.Security.Claims;

namespace Smastad.Controllers
{
    [Authorize(Roles = "Manager")]
    public class ManagerController : Controller
    {
        private readonly IsmastadRepository _repository;
        private readonly ApplicationDbContext _context;
        public ManagerController(IsmastadRepository repository, ApplicationDbContext context)
        {
            _repository = repository;
            _context = context;
        }
        public ViewResult CrimeManager(int id)
        {
            // hämta departmentid
            string userName = User.Identity.Name;

            string departmentId = _context.Employees.Where(e => e.EmployeeId == userName).Select(e => e.DepartmentId).FirstOrDefault();

            TempData["DepartmentId"] = departmentId;
            ViewBag.DepID = departmentId;
            // hämta errandid
            ViewBag.ID = id;
            TempData["ErrandId"] = id;
            return View(_repository);
        }
        public ViewResult StartManager()
        {
            string userName = User.Identity.Name;

            string departmentId = _context.Employees.Where(e => e.EmployeeId == userName).Select(e => e.DepartmentId).FirstOrDefault();

            TempData["DepartmentId"] = departmentId;
            ViewBag.DepID = departmentId;

            return View(_repository);
        }
        // spara ändringar
        public IActionResult SaveInvestigator(string investigator, bool noAction, string reason)
        {
            int errandId = int.Parse(TempData["ErrandId"].ToString());
                _repository.SaveInvestigator(errandId, investigator, noAction,reason);

            return RedirectToAction("CrimeManager", new {id=errandId});
        }

    }
}
