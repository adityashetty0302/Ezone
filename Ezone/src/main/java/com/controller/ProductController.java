package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.dao.SupplierDAO;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public String showProduct(Model m) {
		List<Product> listProduct = productDAO.retrieveProducts();
		m.addAttribute("productList", listProduct);

		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("supplierList", this.getSuppliers());
		m.addAttribute("prodmodel", new Product());
		return "Product";

	}

	public List<String> getCategories() {
		List<Category> listCategories = categoryDAO.retrieveCategory();
		List<String> categoriesList = new LinkedList<String>();

		for (Category category : listCategories) {
			categoriesList.add(category.getCatName());

		}

		return categoriesList;
	}

	public List<String> getSuppliers() {
		List<Supplier> listSuppliers = supplierDAO.retrieveSupplier();
		List<String> suppliersList = new LinkedList<String>();

		for (Supplier supplier : listSuppliers) {
			suppliersList.add(supplier.getSupName());

		}

		return suppliersList;
	}

	@RequestMapping(value = "/admin/AddProduct", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute("prodmodel") Product product,
			@RequestParam("pimage") MultipartFile fileDetail, Model m) {

		productDAO.addProduct(product);

		String path = "C:\\Users\\Aditya Shetty\\Desktop\\Core Java\\Practice\\Eclipse\\Ezone\\src\\main\\webapp\\resources\\";

		String totalFileWithPath = path + String.valueOf(product.getProductId()) + ".jpg";

		File productImage = new File(totalFileWithPath);

		if (!fileDetail.isEmpty()) {
			try {
				byte fileBuffer[] = fileDetail.getBytes();
				FileOutputStream fos = new FileOutputStream(productImage);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			} catch (Exception e) {
				m.addAttribute("error", e.getMessage());
			}
		} else {
			m.addAttribute("error", "Problem in File Uploading");
		}

		List<Product> listProduct = productDAO.retrieveProducts();
		m.addAttribute("productList", listProduct);

		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("supplierList", this.getSuppliers());
		m.addAttribute("prodmodel", new Product());

		return "Product";
	}

	@RequestMapping(value = "/admin/deleteProduct{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model m) {
		Product product = productDAO.getProduct(productId);

		productDAO.deleteProduct(product);

		List<Product> listProduct = productDAO.retrieveProducts();
		m.addAttribute("productList", listProduct);

		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("supplierList", this.getSuppliers());
		m.addAttribute("prodmodel", new Product());

		return "Product";
	}

	@RequestMapping(value = "/admin/updateProduct{productId}", method = RequestMethod.GET)
	public String updateProduct(@PathVariable("productId") int productId, Model m) {
		Product product = productDAO.getProduct(productId);
		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("supplierList", this.getSuppliers());
		m.addAttribute("prodmodel", product);

		List<Product> listProduct = productDAO.retrieveProducts();
		m.addAttribute("productList", listProduct);

		return "UpdateProduct";
	}

	@RequestMapping(value = "/admin/UpdateProduct", method = RequestMethod.POST)
	public String updateMyProduct(@ModelAttribute("prodmodel") Product product, Model m) {
		productDAO.updateProduct(product);

		List<Product> listProduct = productDAO.retrieveProducts();
		m.addAttribute("productList", listProduct);

		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("supplierList", this.getSuppliers());
		m.addAttribute("prodmodel", new Product());

		return "Product";
	}

	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public String showProducts(Model m) {
		List<Product> listProduct = productDAO.retrieveProducts();
		m.addAttribute("productList", listProduct);

		m.addAttribute("prodmodel", new Product());

		return "ProductList";

	}

	@RequestMapping(value = "/productDesc/{productId}", method = RequestMethod.GET)
	public String showProductDesc(@PathVariable("productId") int productId, Model m) {

		Product product = productDAO.getProduct(productId);

		m.addAttribute("prodmodel", product);

		return "ProductDesc";

	}
}
