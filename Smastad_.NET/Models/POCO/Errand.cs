namespace Smastad.Models
{
    using System.ComponentModel.DataAnnotations;
    public class Errand
    {
        public int ErrandId { get; set; }

        public String RefNumber { get; set; }

        [Display(Name = "*Vart har brottet skett någonstans?")]
        [Required(ErrorMessage ="Du måste ange ett plats!")]
        public String Place { get; set; }

        [Display(Name = "*Vilken typ av brott?")]
        [Required(ErrorMessage = "Skriv in en typ av brott!")]
        public String TypeOfCrime { get; set; }

        [Display(Name = "*När skedde brottet?(ÅÅÅÅ, MM, DD)")]
        [Required(ErrorMessage = "Ange ett datum!")]
        [DataType(DataType.Date)]
        public DateTime DateOfObservation { get; set; }

        [Display(Name = "*Ditt namn (för- och efternamn):")]
        [Required(ErrorMessage = "Ange ett namn!")]
        public String InformerName { get; set; }

        [Display(Name = "*Din telefon:")]
        [RegularExpression(pattern: @"^[0]{1}[0-9]{1,3}-[0-9]{5,9}$", ErrorMessage = "Formatet för mobilnummer ska vara xxxx-xxxxxxxxx")]
        public String InformerPhone { get; set; }

        [Display(Name = "*")]
        public String Observation { get; set; }

        public String InvestigatorInfo { get; set; }

        public String InvestigatorAction { get; set; }

        public String StatusId { get; set; }

        public String DepartmentId { get; set; }

        public String EmployeeId { get; set; }

        public ICollection<Sample> Samples { get; set; }
        public ICollection<Picture> Pictures { get; set; }
    }
}
