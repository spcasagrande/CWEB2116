using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Homework3_CWEB2116.Controllers;
using Homework3_CWEB2116.CustomFilters;
using Homework3_CWEB2116.Models;

namespace Homework3_CWEB2116.Controllers
{
    public class BookController : Controller
    {
        BookDatabaseEntities ctx;

        public BookController()
        {
            ctx = new BookDatabaseEntities();
        }

        public ActionResult Index()
        {
            var Books = ctx.Books.ToList();
            return View(Books);
        }

        [AuthLog(Roles = "Manager")]
        public ActionResult Create()
        {
            var Book = new Book();
            return View(Book);
        }

        [HttpPost]
        public ActionResult Create(Book b)
        {
            ctx.Books.Add(b);
            ctx.SaveChanges();
            return RedirectToAction("Index");
        }

		[AuthLog(Roles = "Sales Executive")]
		[HttpGet]
        public ActionResult Edit(int id)
        {
            try
            {
                if (id != 0)
                {
                    Book book_data = ctx.Books.SingleOrDefault(x => x.BookID == id);
                    return View("Edit", book_data);
                }
                else
                {
                    return RedirectToAction("Index");
                }
            }
            catch (Exception)
            {
                ViewBag.msg = "Some error occured";
                return RedirectToAction("Index");
            }
        }

        [HttpPost]
        public ActionResult Edit(Book book_modified)
        {
            try
            {
                if (book_modified != null)
                {
                    Book book_update = ctx.Books.SingleOrDefault(x => x.BookID == book_modified.BookID);
                    book_update.Title = book_modified.Title;
                    book_update.Author = book_modified.Author;
                    book_update.Price = book_modified.Price;
                    book_update.Quantity = book_modified.Quantity;
                    book_update.CreatedBy = book_modified.CreatedBy;
                    ctx.SaveChanges();
                }
                return RedirectToAction("Index");
            }
            catch (Exception)
            {
				ViewBag.msg = "Some error occured";
				return RedirectToAction("Index");
			}
        }
    }
}