namespace Smastad.Models
{
    public interface IsmastadRepository
    {
        Task<Errand> GetErrandDetail(int id);
        IQueryable<Employee> Employees { get; }
        IQueryable<Department> Departments{ get; }
        IQueryable<ErrandStatus> Errandstatuses { get; }

        //Implementerar i EFSmastadRepository
        //Create och Update
        void SaveErrand(Errand errand);
        void SaveDepartment(int errandId, string department);
        void SaveInvestigator(int errandId, string employeeId,bool act, string motivation);
        void SaveEvent(int errandId, string ev);
        void SaveInfomation(int errandId, string info);
        void SaveStatus(int errandId, string info);
        void SaveImage(int id, IFormFile file, string fileName);
        void SaveSample(int id, IFormFile file, string fileName);
        //Read
        IQueryable<Errand> Errands { get; }

        //Delete
        Errand DeleteErrand(int ErrandId);

        // hämta data
        IQueryable<MyErrand> GetErrandsByDepartment(string departmentId);
        IQueryable<MyErrand> GetErrandsByEmployeeId(string employeeId);
        IQueryable<Employee> GetEmployee(string departmentId);
        IQueryable<MyErrand> myErrands();
    }
}
