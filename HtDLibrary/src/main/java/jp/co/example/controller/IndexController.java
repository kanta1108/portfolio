package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.example.dto.form.BookSearchForm;

/**
 * 初期表示用コントローラ</br>
 * ウェルカムページ表示に関するコントローラ
 * 
 * @author k.s
 * @version 1.0 BMS2106001 初期構築
 *
 */
@Controller
public class IndexController {
	
	/**
	 * コンテキスト用</br>
	 * thymeleafの機能を利用するため、空のフォームをmodelに入れてから遷移。
	 * 
	 * @param model
	 * @return 検索画面
	 */
	@GetMapping("/")
	public String welcome(Model model) {
		
		// th:field="*{title}"を利用したいので、フォーム情報を生成、セット。
		BookSearchForm form = new BookSearchForm();
		model.addAttribute("bookSearchForm", form);
		return "index";
	}
	
	/**
	 * index用</br>
	 * 「/index」でコールされたとき用。</br>
	 * 処理としては、コンテキスト用と同じなので、メソッド呼び出しで対応。
	 * 
	 * @param model
	 * @return 検索画面
	 */
	@GetMapping("/index")
	public String index(Model model) {
		
		// コンテキストパスを入力した場合と同じ処理を行う。
		return welcome(model);
	}

}
