package com.hejinwei.majiang.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hejinwei.majiang.api.form.ArchiveVO;
import com.hejinwei.majiang.api.form.UploadForm;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping("/login")
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping("/RequestDispathcherAtcion.do1")
	@ResponseBody
	public String queryAction(@RequestParam("method") String method, @RequestParam("username") String username) {
		System.out.println(username);
		return "queryActionFinished";
	}

	@RequestMapping("/logon.do")
	public String doLogon(@RequestParam("method") String method, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pws", required = false) String pws, @RequestParam(value = "time", required = false) String time, HttpSession httpSession) {
		System.out.println(method);
		System.out.println(name);
		System.out.println(pws);
		System.out.println(time);

		httpSession.setAttribute("name", name);

		return "index";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("name");
		return "redirect:/login";
	}

	@RequestMapping("/goArchive.do")
	public String goArchive(HttpSession httpSession) {

		if (httpSession.getAttribute("name") == null) {
			return "login";
		}

		return "upload";
	}

	@RequestMapping("/Archive.do")
	@ResponseBody
	public String addArchive(HttpSession httpSession, @RequestParam(value = "method", required = false) String method,
			@RequestParam(value = "qpCreditReportId", required = false) String qpCreditReportId,
			@RequestParam(value = "archiveOperateMethod", required = false) String archiveOperateMethod,
			@RequestParam(value = "random", required = false) String random, UploadForm uploadForm,
			@RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile) {

		if (httpSession.getAttribute("name") == null) {
			return "login";
		}

		System.out.println(method);
		System.out.println(qpCreditReportId);
		System.out.println(archiveOperateMethod);
		System.out.println(random);
//		System.out.println(uploadfile);

		ArchiveVO archiveVO = uploadForm.getArchiveVO();
		System.out.println(archiveVO.getQuerierName());
		
		AddArchiveResp resp = new AddArchiveResp();
		resp.setResult(true);
		resp.setTotalCount(1);
		resp.setArchiveId(123);

		String respStr = JSON.toJSONString(resp);
		
		return respStr;
	}

}

class AddArchiveResp {
	private boolean result;
	
	private boolean existRecord;
	
	private int totalCount;
	
	private long archiveId;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean isExistRecord() {
		return existRecord;
	}

	public void setExistRecord(boolean existRecord) {
		this.existRecord = existRecord;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public long getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(long archiveId) {
		this.archiveId = archiveId;
	}
}
