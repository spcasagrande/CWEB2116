using System.Web;
using System.Web.Mvc;

namespace Homework3_CWEB2116
{
	public class FilterConfig
	{
		public static void RegisterGlobalFilters(GlobalFilterCollection filters)
		{
			filters.Add(new HandleErrorAttribute());
		}
	}
}
