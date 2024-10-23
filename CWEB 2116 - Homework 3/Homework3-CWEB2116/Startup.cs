using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Homework3_CWEB2116.Startup))]
namespace Homework3_CWEB2116
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
