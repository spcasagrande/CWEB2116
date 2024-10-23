using System.Web.Mvc;

namespace Homework3_CWEB2116.CustomFilters
{
	public class AuthLogAttribute : AuthorizeAttribute
	{
		public AuthLogAttribute() 
		{
			View = "AuthorizeFailed";
		}

		public string View { get; set; }

		public override void OnAuthorization(AuthorizationContext filterContext)
		{
			base.OnAuthorization(filterContext);
			IsUserAuthorized(filterContext);
		}

		private void IsUserAuthorized(AuthorizationContext filterContext)
		{
			if (filterContext.Result == null)
			{
				return;
			}

			if (filterContext.HttpContext.User.Identity.IsAuthenticated)
			{
				var vr = new ViewResult();
				vr.ViewName = View;

				ViewDataDictionary dict = new ViewDataDictionary();
				dict.Add("Message", "Sorry. You are not authorized to perform this action");

				vr.ViewData = dict;

				var result = vr;

				filterContext.Result = result;
			}
		}
	}
}