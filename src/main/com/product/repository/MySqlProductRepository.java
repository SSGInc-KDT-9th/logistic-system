package main.com.product.repository;

import main.com.config.MySqlSessionFactory;
import main.com.product.domain.Product;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

public class MySqlProductRepository implements ProductRepository{
    @Override
    public Product findById(Long id) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            Product product = sqlSession.selectOne("mapper.product.findById",id);
            return product;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<Product> findByName(String productName) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<Product> products= sqlSession.selectList("mapper.product.findByName",productName);
            return products;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<Product> findBySupplyName(String supplyName) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<Product> products= sqlSession.selectList("mapper.product.findBySupplyName",supplyName);
            return products;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public Long save(Product product) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            int success = sqlSession.insert("mapper.product.insert", product);
            sqlSession.commit();
            return product.getId();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<Long> save(List<Product> products) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            int success = sqlSession.insert("mapper.product.insertList", products);
            sqlSession.commit();
            return products.stream().map(Product::getId).collect(Collectors.toList());
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public Long update(Product product) {
        return null;
    }

    @Override
    public void delete(Product product) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            int success = sqlSession.insert("mapper.product.delete", product.getId());
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Override
    public List<Long> delete(List<Product> products) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            List<Long> ids = products.stream().map(Product::getId).collect(Collectors.toList());
            sqlSession.delete("mapper.product.deleteList", ids);
            sqlSession.commit();
            return ids;
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    public void deleteAll(){
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        try {
            int success = sqlSession.insert("mapper.product.deleteAll");
            sqlSession.commit();
        }
        finally{
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
