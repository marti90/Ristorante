package it.alfasoft.martina.dao;

import it.alfasoft.martina.Prodotto;
import it.alfasoft.martina.utility.HibernateUtility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProdottoDAO {
	
	//1- CREATE
	public boolean createProdotto(Prodotto p){
			
		boolean res = false;
			
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
				
			session.persist(p);
			
			tx.commit();
			res= true;
			
		}catch(Exception ex){
			tx.rollback();
				
		}finally{
			session.close();
				
		}
			
		return res;
	}
	
	//2.a- READ con nome
	public Prodotto readProdottoConNome(String nome){
			
		Prodotto p = null;
			
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
			
			Query query=session.createQuery("from Prodotto where nome=:nomeInserito");
			query.setString("nomeInserito",nome);
	        p=(Prodotto) query.uniqueResult();
				
			tx.commit();
				
		}catch(Exception ex){
			tx.rollback();
				
		}finally{
				session.close();
				
		}
		
		return p;
	}
		
	//2.c- READ con id
			public Prodotto readProdottoConId(long id){
				
				Prodotto p = null;
				
				Session session = HibernateUtility.openSession();
				Transaction tx = null;
				
				try{
					tx = session.getTransaction();
					tx.begin();
					
					p= session.get(Prodotto.class, id);
					
					tx.commit();
					
				}catch(Exception ex){
					tx.rollback();
					
				}finally{
					session.close();
					
				}
				
				return p;
			}
	
	//2.d READ tutti i prodotti della tabella
	@SuppressWarnings("unchecked")
	public List<Prodotto> readProdotto(){
		
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        Query query = session.createQuery("from Prodotto");
	        prodotti= query.list();
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return prodotti;
		
	}
	
	//3- UPDATE
	public boolean updateProdotto(Prodotto p){

		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.update(p);
			
			tx.commit();
			res= true;
			
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}
	
	//4- DELETE
	public boolean deleteProdotto(Prodotto p){
        
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.delete(p);
			
			tx.commit();
			res= true;
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}


}
