package com.mtc.app.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mtc.app.vo.Product;

@Repository
public class ProductDAO implements IProductDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private ProductRowMapper productRowMapper;

	private final static String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
	//1,2,3,4,5

	private final static String insertNamedQuery = "insert into test.product(id,name,price,description,quantity) values(:id,:name,:price,:description,:quantity)";

	private final static String selectQuery = "select * from test.product";

	private final static String selectQueryById = "select * from test.product where id = ?";

	private final static String maxPriceQuery = "select max(price) from test.product";

	private final static String selectByPageQuery = "SELECT * FROM test.product LIMIT ?,?";

	public static Product productMapRow(ResultSet resultSet,int rno) {
		Product product = new Product();

		try {
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getFloat("price"));
			product.setDescription(resultSet.getString("description"));
			product.setQuantity(resultSet.getInt("quantity"));

		}catch (Exception e) {			
			e.printStackTrace();
		}
		return product;

	}

	public boolean addProduct(Product product) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id", product.getId());
		parameterSource.addValue("name", product.getName());
		parameterSource.addValue("price", product.getPrice());
		parameterSource.addValue("description", product.getDescription());
		parameterSource.addValue("quantity", product.getQuantity());

		int noRows = namedParameterJdbcTemplate.update(insertNamedQuery, parameterSource);

		if(noRows == 1) {
			return true;
		}

		return false;
	}

	@Override
	public float findMaxPrice() {

		float maxPrice = jdbcTemplate.queryForObject(maxPriceQuery, Float.class);

		return maxPrice;
	}

	@Override
	public Product findById(int id) {

		Product product = jdbcTemplate.queryForObject(selectQueryById, ProductDAO::productMapRow,id);

		return product;
	}

	@Override
	public List<Product> findAll() {

		//		RowMapper<Product> rowMapper = (ResultSet resultSet,int rno) -> {
		//			Product product = new Product();
		//			
		//			product.setId(resultSet.getInt("id"));
		//			product.setName(resultSet.getString("name"));
		//			product.setPrice(resultSet.getFloat("price"));
		//			product.setDescription(resultSet.getString("description"));
		//			product.setQuantity(resultSet.getInt("quantity"));
		//			
		//			return product;
		//		};

		//List<Product> products = jdbcTemplate.query(selectQuery, productRowMapper);

		List<Product> products = jdbcTemplate.query(selectQuery, ProductDAO::productMapRow);

		return products;
	}

	@Override
	public boolean add(Product product) {

		int noOfRows = jdbcTemplate.update(insertQuery,product.getId(),product.getName(),product.getPrice(),product.getDescription(),product.getQuantity());

		if(noOfRows == 1)
			return true;

		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getpProductsByPage(int pageid, int total) {

		return jdbcTemplate.query(selectByPageQuery, ProductDAO::productMapRow,pageid,total);
	}

}
