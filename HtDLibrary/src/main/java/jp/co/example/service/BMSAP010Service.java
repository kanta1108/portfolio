package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.bean.BookBean;

/**
 * 書籍検索サービス</br>
 * 書籍検索に関するサービスクラス
 * 
 * @author k.s
 * @version 1.0 BMS2106001 初期構築
 * 
 */
public interface BMSAP010Service {

	/**
	 * 書籍名検索(あいまい検索)</br>
	 * 
	 * @param title 書籍名
	 * @return 書籍名にヒットする書籍のリスト
	 */
	public List<BookBean> getBookByTitle(String title);

}