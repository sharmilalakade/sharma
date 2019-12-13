package com.scp.sixteen.java.CrudOpe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ProMain {
	
		static SessionFactory sfactory =null;
		public static SessionFactory getSessionFactory() 
		{
			if(sfactory==null) 
			{
				sfactory = new Configuration().configure().buildSessionFactory();
			}
			return sfactory;
		}
		private static void cleanUpResources(Session session, Transaction tr) 
		{
			if(session!=null) 
			{
				if(tr!=null)
				{
					session.flush();
					tr.commit();
				}
				session.close();
			}
		}
		
		//Add Product
		public static void addProduct(Product p)
		{
			SessionFactory sfactory = getSessionFactory();
			Session session = sfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(p);
			cleanUpResources(session,tr);
			System.out.println("Product Saved Successfully....!");

		}
		
		//Retrieve product
		public static Product getProduct(int productId)
		{
			SessionFactory sfactory = getSessionFactory();
			Session session = sfactory.openSession();
			Product product = session.get(Product.class, productId);
			cleanUpResources(session,null);
			System.out.println(product);
			return product;

		}
		
	/*
	 * //Retrieve all products public static void getAllProduct() { SessionFactory
	 * sfactory = getSessionFactory(); Session session = sfactory.openSession();
	 * Query query = session.createQuery("from Product"); List<Product> products =
	 * query.list(); cleanUpResources(session,null); System.out.println(products);
	 * 
	 * }
	 * 
	 * //update product public static void updateProduct(Product prod) { Product
	 * dbProduct = getProduct(prod.getProductId()); if(dbProduct!=null) {
	 * SessionFactory sfactory = getSessionFactory(); Session session =
	 * sfactory.openSession(); Transaction tr = session.beginTransaction();
	 * dbProduct.setProductLabel("abc"); dbProduct.setProductName("rohya");
	 * dbProduct.setProductPrice(prod.getProductPrice());
	 * dbProduct.setProductQty(prod.getProductQty()); session.update(prod); //
	 * session.save(prod); System.out.println("Product Updated Successfully...!");
	 * cleanUpResources(session,tr); }else {
	 * System.out.println("Product not found so cannot update"); }
	 * 
	 * }
	 */		
		//delete product
		public static void deleteProduct(int productId)
		{
			Product dbProduct = getProduct(productId);
			if(dbProduct!=null) {
				SessionFactory sfactory = getSessionFactory();
				Session session = sfactory.openSession();
				Transaction tr = session.beginTransaction();
				//dbProduct.setProductLabel(prod.getProductLabel());
				//dbProduct.setProductName(prod.getProductName());
			//	dbProduct.setProductPrice(prod.getProductPrice());
			//	dbProduct.setProductQty(prod.getProductQty());
				session.delete(dbProduct);
				System.out.println("Product deleted Successfully...!");
				cleanUpResources(session,tr);
			}else {
				System.out.println("Product not found so cannot delete");
			}

		}


public static void main(String[] args) {
			 {
				Product s1=new Product(101,"Pen");
				Product s2=new Product(102,"Pencil");
				Product s3=new Product(111,"Book");
				Product s4=new Product(123,"NoteBook");
				Product s5=new Product(145,"Erraser");
				
				System.out.println("Hello...........");
				
				SessionFactory sFactory = new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
				Session s = sFactory.openSession();
				Transaction tr = s.beginTransaction();
				s.save(s1);
				s.save(s2);
				s.save(s3);
				s.save(s4);
				s.save(s5);
				
				s.flush();
				tr.commit();
				}
			}

			
		}






