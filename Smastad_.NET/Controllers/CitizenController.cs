using Microsoft.AspNetCore.Mvc;
using Smastad.Models;
using Smastad.Infrastructure;

namespace Smastad.Controllers
{
    public class CitizenController : Controller
    {
        private readonly IsmastadRepository _repository;
        public CitizenController(IsmastadRepository repository)
        {
            _repository = repository;
        }
        public ViewResult Contact()
        {
            return View();
        }
        public ViewResult FAQ()
        {
            return View();
        }
        public ViewResult Services()
        {
            return View();
        }
        public ViewResult Thanks()
        {
            // Hämta ut från sessionen för att spara i databasen
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



    }
}
