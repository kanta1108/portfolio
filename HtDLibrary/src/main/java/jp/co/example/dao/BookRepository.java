package jp.co.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.example.dto.entity.Book;

/**
 * 書籍テーブル用DAO
 * 
 * @author k.s
 * @version 1.0 BMS2106001 初期構築
 * 
 */
@Repository
public interface BookRepository extends JpaRepository<Book ,Integer>{
	
	/**
	 * 書籍名検索(あいまい検索)
	 * 
	 * @param title 書籍名
	 * @return ヒットした書籍のリスト
	 */
	List<Book> findByTitleContainingOrderByIdAsc(String title);
	
}
