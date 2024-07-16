using System.ComponentModel.DataAnnotations;

namespace Smastad.Models
{
    public class ErrandStatus
    {
        [Key]
        public String StatusId { get; set; }
        public String StatusName { get; set; }
    }
}
