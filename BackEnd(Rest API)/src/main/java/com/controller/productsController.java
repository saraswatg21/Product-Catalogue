package com.controller;

import java.io.IOException;

import java.util.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Image;
import com.entity.Products;
import com.repo.ProductsRepo;


@RestController
@CrossOrigin
public class productsController {

	@Autowired
	ProductsRepo repo;
	
	
	@GetMapping(path="/products", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public List<Products> getProducts(@RequestPart("products")Products products,
			@RequestPart("image")MultipartFile[] file)
	{
		try {
			Set<Image> images = uploadImage(file);
			products.setProductImages(images);
		    return repo.findAll();
		}
		//return repo.findAll();
		catch(Exception e){
			System.out.println(e.getMessage());
		return null;}
	}
	public Set<Image> uploadImage(MultipartFile[] multipartFiles)throws IOException {
		Set<Image> image= new HashSet<>();
		for(MultipartFile file: multipartFiles) {
			Image images= new Image(
					file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes()
					);
			image.add(images);
		}
		return image;
	}
	
	@RequestMapping("/products/id/{id}")
	public Optional<Products> getID(@PathVariable("id") int id)
	{
		return repo.findById(id);

	}
	
	@RequestMapping("/products/code/{code}")
	public List<Products> getCode(@PathVariable("code") String code)
	{
		return repo.findByCode(code);

	}
	
	@RequestMapping("/products/name/{name}")
	public List<Products> getName(@PathVariable("name") String name)
	{
		return repo.findByName(name);

	}
	
	@RequestMapping("/products/brand/{brand}")
	public List<Products> getBrand(@PathVariable("brand") String brand)
	{
		return repo.findByBrand(brand);

	}
	
	@RequestMapping("/products/price/{price}")
	public List<Products> getPrice(@PathVariable("price") double price)
	{
		return repo.findByPriceLessThanEqual(price);

	}
	
}
