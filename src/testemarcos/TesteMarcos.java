/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testemarcos;

import Tabelas.Componente;
import Tabelas.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author cemancini
 */
public class TesteMarcos {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        /*
        Produto produto1 = new Produto();
        produto1.setCodigo("D");
        produto1.setDescricao("Produto D");
        produto1.setComponentes(null);
        
        Produto produto2 = new Produto();
        produto2.setCodigo("E");
        produto2.setDescricao("Produto E");
        produto2.setComponentes(null);
        
        Produto produto3 = new Produto();
        produto3.setCodigo("F");
        produto3.setDescricao("Produto F");
        produto3.setComponentes(null);
        
        Produto produto4 = new Produto();
        produto4.setCodigo("F");
        produto4.setDescricao("Produto F");
        produto4.setComponentes(null);
        
        Produto produto5 = new Produto();
        produto5.setCodigo("G");
        produto5.setDescricao("Produto G");
        produto5.setComponentes(null);
        
        session.saveOrUpdate(produto1);
        session.saveOrUpdate(produto2);
        session.saveOrUpdate(produto3);
        session.saveOrUpdate(produto4);
        session.saveOrUpdate(produto5);
        
        Criteria select = session.createCriteria(Produto.class);
        select.add(Restrictions.like("codigo", "H", MatchMode.ANYWHERE));
        Produto prod = (Produto)select.list().get(0);
        
        select = session.createCriteria(Produto.class);
        select.add(Restrictions.like("codigo", "E", MatchMode.ANYWHERE));
        Produto prod2 = (Produto)select.list().get(0);
        
        select = session.createCriteria(Produto.class);
        select.add(Restrictions.like("codigo", "G", MatchMode.ANYWHERE));
        Produto prod3 = (Produto)select.list().get(0); 
        
        Componente cmp1 = new Componente();
        cmp1.setComponente(prod2);
        cmp1.setModelo(prod);
        cmp1.setQuantidade(2.0);
        session.saveOrUpdate(cmp1);
        Componente cmp2 = new Componente();
        cmp2.setComponente(prod3);
        cmp2.setModelo(prod);
        cmp2.setQuantidade(2.0);
        session.saveOrUpdate(cmp2);
        session.saveOrUpdate(prod);
        */
        
        Criteria select = session.createCriteria(Produto.class);
        select.add(Restrictions.like("codigo", "A", MatchMode.ANYWHERE));
        Produto prod = (Produto)select.list().get(0);
        
        String cmpTxt = prod.getDescricao();
        System.out.println(cmpTxt);
        estrutura(prod, cmpTxt);
        
        tx.commit();
        session.close();
    }
    
    public static void estrutura(Produto prod, String cmpTxt){
        for(Componente cmp : prod.getComponentes()){
            String strTmp = cmpTxt;
            cmpTxt += " => " + cmp.getComponente().getDescricao();
            Produto prod2 = (Produto) HibernateUtil.openSession().createCriteria(Produto.class)
                    .add(Restrictions.like("codigo", cmp.getComponente().getCodigo(), MatchMode.ANYWHERE))
                    .list().get(0);
            System.out.println(cmpTxt);
            
            if(prod2.getComponentes().size() > 0){
                prod = prod2;
                estrutura(prod, cmpTxt);
            } 
            cmpTxt = strTmp;
        }
    }
}
