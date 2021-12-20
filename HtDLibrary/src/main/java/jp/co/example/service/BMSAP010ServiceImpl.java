package jp.co.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.BookRepository;
import jp.co.example.dto.bean.BookBean;
import jp.co.example.dto.entity.Book;

/**
 * 書籍検索サービス</br>
 * 書籍検索に関するサービスの実装クラス
 * 
 * @author k.s
 * @version 1.0 BMS2106001 初期構築
 * 
 */
@Service
public class BMSAP010ServiceImpl implements BMSAP010Service {

	/**
	 * 書籍テーブルDAO
	 */
	@Autowired
	private BookRepository bookRepository;

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BookBean> getBookByTitle(String title) {
		// 引数で渡されたタイトルをもとに、あいまい検索を行う。
		List<Book> bookList = bookRepository.findByTitleContainingOrderByIdAsc(title);
		
		//Entityの値を、Beanに詰め直す
		List<BookBean> resultList = new ArrayList<BookBean>();
		
		for(Book book : bookList) {
			BookBean bookBean = new BookBean();
			BeanUtils.copyProperties(book, bookBean);
			resultList.add(bookBean);
		}
		
		return resultList;
	}

}
