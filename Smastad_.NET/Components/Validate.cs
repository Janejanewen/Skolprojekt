using Microsoft.AspNetCore.Mvc;

namespace Smastad.Components
{
	public class Validate:ViewComponent
	{
        public IViewComponentResult Invoke()
        {
            return View("Validate");
        }
    }
}
