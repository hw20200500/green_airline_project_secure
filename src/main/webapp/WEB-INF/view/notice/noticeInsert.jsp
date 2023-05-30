<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<style>
</style>

<c:choose>
	<c:when test="${\"관리자\".equals(principal.userRole)}">
		<%@ include file="/WEB-INF/view/layout/headerManager.jsp"%>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/view/layout/header.jsp"%>
	</c:otherwise>
</c:choose>

<input type="hidden" name="menuName" id="menuName" value="공지사항">

<div>
	<main>
		<h1>관리자 쪽 공지사항 작성</h1>
		<form action="/notice/noticeInsert" method="post">
			제목 <input type="text" name="title"> 
			<select name="categoryId" id="categoryId">
				<optgroup label="카테고리">
					<c:forEach var="categoryList" items="${categoryList}">
						<option value="${categoryList.id}">${categoryList.name}</option>
					</c:forEach>
				</optgroup>
			</select>
			<textarea class="form-control summernote" rows="5" id="content" name="content"></textarea>
			<button type="submit">올리기</button>
		</form>
	</main>

	<script>
		$('.summernote').summernote(
				{
					tabsize : 2,
					height : 500,
					toolbar: [
				          ['style', ['style']],
				          ['font', ['bold', 'underline', 'clear']],
				          ['color', ['color']],
				          ['para', ['ul', 'ol', 'paragraph']],
				          ['table', ['table']],
				          ['insert', ['link', 'picture', 'video']],
				          ['view', ['fullscreen', 'codeview', 'help']]
				        ]
				});
		$(document).ready(function() {
			$('#summernote').summernote();
		});

		$(".custom-file-input").on(
				"change",
				function() {
					var fileName = $(this).val().split("\\").pop();
					$(this).siblings(".custom-file-label").addClass("selected")
							.html(fileName);
				});
	</script>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
