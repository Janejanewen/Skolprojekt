using System.ComponentModel.DataAnnotations;

namespace Smastad.Models
{
	public class MyErrand
	{
        public DateTime DateOfObservation { get; set; }
        [Key]
        public int ErrandId { get; set; }
		public string RefNumber { get; set; }
		public string TypeOfCrime { get; set; }
		public string StatusName { get; set; }
		public string DepartmentName { get; set; }
		public string EmployeeName { get; set; }
	}
}
