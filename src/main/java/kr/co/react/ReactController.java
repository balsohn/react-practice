package kr.co.react;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ReactController {

	@Autowired
	private ReactMapper mapper;
	
	@PostMapping("/content")
	public ResponseEntity<Map<String,Object>> write(@RequestBody Map<String,String> content) {
		boolean isWrite=mapper.write(content);
		Map<String,Object> response=new HashMap<>();
		
		if(isWrite) {
			response.put("success", true);
			response.put("message", "글 등록이 완료되었습니다");
		} else {
			response.put("success", false);
			response.put("message", "글등록 실패");
		}
		return ResponseEntity.ok(response);
	}
}
