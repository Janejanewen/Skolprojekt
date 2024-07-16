using Microsoft.EntityFrameworkCore;
using static System.Net.Mime.MediaTypeNames;

namespace Smastad.Models
{
    public class EFSmastadRepository: IsmastadRepository // metoderna
    {
        private readonly ApplicationDbContext _context;
        private readonly IWebHostEnvironment _env;

        public EFSmastadRepository(ApplicationDbContext context, IWebHostEnvironment env)
        {
            _context = context;
            _env = env;
        }

        public IQueryable<Errand> Errands => _context.Errands.Include(e => e.Samples).Include(e => e.Pictures);
        public IQueryable<Employee> Employees => _context.Employees;
        public IQueryable<Department> Departments => _context.Departments;
        public IQueryable<ErrandStatus> Errandstatuses => _context.ErrandStatuses;
        public IQueryable<Picture> Pictures => _context.Pictures;
        public IQueryable<Sample> Samples => _context.Samples;
        public IQueryable<Sequence> Sequences => _context.Sequences;



        public Task<Errand> GetErrandDetail(int id)
        {
            return Task.Run(
                () =>
                {
                    var errandDetail = Errands.Where(ed => ed.ErrandId == id).First();
                    return errandDetail;
                }
                );
        }
      

        public void SaveErrand(Errand errand)
        {
            if (errand.ErrandId == 0)
            { 
                var idCheck = _context.Sequences.FirstOrDefault(idNummer => idNummer.Id == 1);
                errand.RefNumber = "2022-45-" + idCheck.CurrentValue;
                errand.StatusId = "S_A";
                idCheck.CurrentValue++;
                _context.Errands.Add(errand);
            }
            
            _context.SaveChanges();
        }
        public Errand DeleteErrand(int id)
        {
            Errand dbEntry = _context.Errands.FirstOrDefault(ed => ed.ErrandId == id);
            if( dbEntry!=null)
            { _context.Errands.Remove(dbEntry); }
            _context.SaveChanges();
            return dbEntry;
        }

        public void SaveDepartment(int errandId, string department)
        {
            Errand dbEntry = _context.Errands.FirstOrDefault(ed => ed.ErrandId == errandId);
            if (dbEntry != null)
            {
                dbEntry.DepartmentId = department;
            }
            _context.SaveChanges();
            
        }

        public void SaveInvestigator(int errandId,string employeeId, bool act,string motivation)
        {
            Errand dbEntry = _context.Errands.FirstOrDefault(ed => ed.ErrandId == errandId);
            if (dbEntry != null)
            {
                if (act) // ingen återgärd
                {
                    dbEntry.StatusId = "S_B";
                    dbEntry.InvestigatorInfo = motivation;
                    dbEntry.EmployeeId = null;

                }
                else if (!act)
                {
                    dbEntry.StatusId = "S_C";
                    dbEntry.EmployeeId = employeeId;
                    dbEntry.InvestigatorInfo = null;
                    
                }
            }
            _context.SaveChanges();

        }

       public void SaveEvent(int errandId,string ev)
        {
            Errand dbEntry = _context.Errands.FirstOrDefault(ed => ed.ErrandId == errandId);
            if(dbEntry != null && ev != null)
            {
                string old=dbEntry.InvestigatorAction;

                dbEntry.InvestigatorAction = old+"\n"+ev;
            }
            _context.SaveChanges();

        }

        public void SaveInfomation(int errandId, string info)
        {
            Errand dbEntry = _context.Errands.FirstOrDefault(ed => ed.ErrandId == errandId);
            if (dbEntry != null && info != null)
            {
                string old = dbEntry.InvestigatorInfo;

                dbEntry.InvestigatorInfo = old + "\n" + info;
            }
            _context.SaveChanges();

        }

        public void SaveStatus(int errandId, string status_)
        {
            Errand dbEntry = _context.Errands.FirstOrDefault(ed => ed.ErrandId == errandId);
            if (dbEntry != null && status_ != "Välj")
            {
                string old = dbEntry.StatusId;

                dbEntry.StatusId = status_;
            }
            _context.SaveChanges();

        }

        public void SaveSample(int id, IFormFile file, string fileName)
        {
            var sample = new Sample
            {
                SampleName = fileName,
                ErrandId = id
            };
            _context.Samples.Add(sample);
            _context.SaveChanges();

        }

        public void SaveImage(int id, IFormFile file, string fileName)
        {
            var image = new Picture
            {
                PictureName = fileName,
                ErrandId = id
            };

            _context.Pictures.Add(image);
            _context.SaveChanges();

        }
        // hämta data
        public IQueryable<MyErrand> GetErrandsByDepartment(string departmentId)
        {
            var errandList = from err in Errands
                             join stat in Errandstatuses on err.StatusId equals stat.StatusId
                             join dep in Departments on err.DepartmentId equals dep.DepartmentID
                             into departmentErrand
                             from deptE in departmentErrand.DefaultIfEmpty()
                             join em in Employees on err.EmployeeId equals em.EmployeeId
                             into employeeErrand
                             from empE in employeeErrand.DefaultIfEmpty()
                             where err.DepartmentId == departmentId
                             orderby err.DateOfObservation descending // den senaste ärende visar lägsta upp på listan
                             select new MyErrand
                             {
                                 DateOfObservation = err.DateOfObservation,
                                 ErrandId = err.ErrandId,
                                 RefNumber = err.RefNumber,
                                 TypeOfCrime = err.TypeOfCrime,
                                 StatusName = stat.StatusName,
                                 DepartmentName = (err.DepartmentId == null ? "ej tillsatt" : deptE.DepartmentName),
                                 EmployeeName = (err.EmployeeId == null ? "ej tillsatt" : empE.EmployeeName)
                             };

            return errandList;
        }

        public IQueryable<MyErrand> GetErrandsByEmployeeId(string employeeId)
        {
            var errandList = from err in Errands
                             join stat in Errandstatuses on err.StatusId equals stat.StatusId
                             join dep in Departments on err.DepartmentId equals dep.DepartmentID
                             into departmentErrand
                             from deptE in departmentErrand.DefaultIfEmpty()
                             join em in Employees on err.EmployeeId equals em.EmployeeId
                             into employeeErrand
                             from empE in employeeErrand.DefaultIfEmpty()
                             where err.EmployeeId == employeeId
                             orderby err.DateOfObservation descending // den senaste ärende visar lägsta upp på listan
                             select new MyErrand
                             {
                                 DateOfObservation = err.DateOfObservation,
                                 ErrandId = err.ErrandId,
                                 RefNumber = err.RefNumber,
                                 TypeOfCrime = err.TypeOfCrime,
                                 StatusName = stat.StatusName,
                                 DepartmentName = (err.DepartmentId == null ? "ej tillsatt" : deptE.DepartmentName),
                                 EmployeeName = (err.EmployeeId == null ? "ej tillsatt" : empE.EmployeeName)
                             };

            return errandList;
        }


        public IQueryable<MyErrand> myErrands()
        {
            var errandList = from err in Errands
                             join stat in Errandstatuses on err.StatusId equals stat.StatusId
                             join dep in Departments on err.DepartmentId equals dep.DepartmentID
                             into departmentErrand
                             from deptE in departmentErrand.DefaultIfEmpty()
                             join em in Employees on err.EmployeeId equals em.EmployeeId
                             into employeeErrand
                             from empE in employeeErrand.DefaultIfEmpty()
                             orderby err.DateOfObservation descending
                             select new MyErrand
                             {
                                 DateOfObservation = err.DateOfObservation,
                                 ErrandId = err.ErrandId,
                                 RefNumber = err.RefNumber,
                                 TypeOfCrime = err.TypeOfCrime,
                                 StatusName = stat.StatusName,
                                 DepartmentName = (err.DepartmentId == null ? "ej tillsatt" : deptE.DepartmentName),
                                 EmployeeName = (err.EmployeeId == null ? "ej tillsatt" : empE.EmployeeName)
                             };

            return errandList;

        }

        public IQueryable<Employee> GetEmployee(string departmentId)
        {
            return _context.Employees
                            .Where(e => e.DepartmentId == departmentId);
        }


    }


}
