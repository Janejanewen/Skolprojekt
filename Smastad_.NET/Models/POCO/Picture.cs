using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace Smastad.Models
{
    public class Picture
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int PictureId { get; set; }
        public String PictureName { get; set; }
        public int ErrandId { get; set; }
    }
}
