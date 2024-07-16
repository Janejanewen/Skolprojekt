using Microsoft.AspNetCore.Mvc;
using Smastad.Models;
using System.Threading.Tasks;
namespace Smastad.Components
{
    public class Report : ViewComponent
    {
      
    public IViewComponentResult Invoke()
        {
            return View("Report");
        }
    
    }
}
