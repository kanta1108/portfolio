package jp.co.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.example.dto.bean.BookBean;
import jp.co.example.dto.form.BookSearchForm;
import jp.co.example.service.BMSAP010Service;

/**
 * 検索用コントローラ</br>
 * 検索に関するコントローラ
 * 
 * @author k.s
 * @version 1.0 BMS2106001 初期構築
 *
 */
@Controller
public class SearchController {
	
	/**
	 * 書籍検索サービス
	 */
	@Autowired
	private BMSAP010Service service;
	
	/**
	 * 書籍検索用コントローラ(POST)</br>
	 * 検索画面で検索ボタンが押下されたときに実行
	 * 
	 * @param form フォーム情報
	 * @param result 入力チェック結果
	 * @param model
	 * @return (入力チェックNG)検索画面 / (入力チェックOK)検索結果表示画面
	 */
	@PostMapping(path="/search")
	public String getBookList(@Valid @ModelAttribute BookSearchForm form, BindingResult result, Model model) {
		
		// フォームの入力値にエラーがある場合
		if(result.hasErrors()) {
			// エラーメッセージを設定して、検索画面に戻る
			model.addAttribute("errorMsg", "タイトルを入力してください");
			return "index";
		}
		
		// フォームの情報をもとに、書籍検索サービスのタイトル検索を呼び出し
		List<BookBean> resultList = service.getBookByTitle(form.getTitle());
		
		// サービスから取得した情報をmodelに設定
		model.addAttribute("resultList", resultList);
		
		
		//検索条件をmodelに設定
		model.addAttribute("title", form.getTitle());
		
		// 検索結果表示画面へ
		return "searchresult";
	}

}
