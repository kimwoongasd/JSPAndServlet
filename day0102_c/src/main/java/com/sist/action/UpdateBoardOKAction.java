package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class UpdateBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*5,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		BoardVO b = new BoardVO();
		b.setNo(Integer.parseInt(multi.getParameter("no")));
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));
		String oldFname = multi.getParameter("fname");
		String fname = multi.getOriginalFileName("upload");
		b.setFname(fname);
		if (fname == null) {
			b.setFname(oldFname);
		}
		b.setIp(request.getRemoteAddr());
		String viewPage = "updateBoardOK.jsp";
		int re = dao.update(b);
		if (re == 1) {
			if (fname != null) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		} else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "수정 실패");
		}
		return viewPage;
	}

}
