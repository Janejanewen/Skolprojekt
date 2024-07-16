using Microsoft.AspNetCore.Mvc;
using Smastad.Models;
using Smastad.Infrastructure;//session

namespace Smastad.Controllers
{
    public class HomeController : Controller
    {
        public ViewResult Index()
        {
            var myErrand = HttpContext.Session.Get<Errand>("NewErrand");
            if(myErrand != null)
            {
                return View(myErrand);
            }
            else
            {
                return View();
            }
        }


    }
}
