using Smastad.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Identity;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();
builder.Services.AddSession();//session
builder.Services.AddTransient<IsmastadRepository,EFSmastadRepository>();//**ändring till EFS...
//Databasen-- en ny rad för services
builder.Services.AddDbContext<ApplicationDbContext>(options =>
options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));

builder.Services.AddDbContext<AppIdentityDbContext>(options =>
options.UseSqlServer(builder.Configuration.GetConnectionString("IdentityConnection")));

builder.Services.AddIdentity<IdentityUser, IdentityRole>( // kolla på användare och role
    options =>                                         // konfigurera lösenordspolicyn
{
    options.Password.RequireDigit = true;
    options.Password.RequiredLength = 6;
    options.Password.RequireNonAlphanumeric = true;
    options.Password.RequireUppercase = true;
    options.Password.RequireLowercase = true;
    options.Password.RequiredUniqueChars = 1;

}
).AddEntityFrameworkStores<AppIdentityDbContext>();

var app = builder.Build();

//Databasen-- Anrop där vi skapar en service som hämtar vårt testdata
using (var scope = app.Services.CreateScope())
{
    var services = scope.ServiceProvider;
    DBInitializer.EnsurePopulated(services);
    IdentityInitializer.EnsurePopulated(services).Wait();
}

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
}
app.UseStaticFiles();

app.UseRouting();

app.UseSession();//session
app.UseAuthentication();
app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
