using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace Smastad.Models
{
    public class Sample
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int SampleId { get; set; }
        public string SampleName { get; set; }
        public int ErrandId { get; set; }
    }
}
