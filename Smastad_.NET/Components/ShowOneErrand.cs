using Microsoft.AspNetCore.Mvc;
using Smastad.Models;
using System.Threading.Tasks;
namespace Smastad.Components
{
    public class ShowOneErrand:ViewComponent
    {
        private readonly IsmastadRepository repo;
        public ShowOneErrand(IsmastadRepository repo)
        {
            this.repo = repo;
        }

        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            var errandDetail = await repo.GetErrandDetail(id);
            return View("ShowOneErrand", errandDetail);
        }
    }
}
