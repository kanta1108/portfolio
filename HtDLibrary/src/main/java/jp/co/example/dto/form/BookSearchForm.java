package jp.co.example.dto.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * 書籍検索フォーム</br>
 * 検索画面のフォームクラス
 * 
 * @author k.s
 * @version 1.0 BMS2106001 初期構築
 * 
 */
@Data
public class BookSearchForm {
	
	/**
	 * 書籍名</br>
	 * 【入力チェック】 未入力チェック
	 * 【入力チェック】最小値最大値
	 */
	@NotBlank
	@Length(min=1 , max=20)
	private String title;

}
