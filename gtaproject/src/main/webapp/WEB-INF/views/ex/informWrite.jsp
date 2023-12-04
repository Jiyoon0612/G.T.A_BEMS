<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>글쓰기</title>
    </head>
    <body id="page-top">

        <!-- Contact Section-->
        <section class="page-section" id="contact">
            <div class="container" style="margin-top: 100px;">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">글 작성</h2>
                
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <form action="<c:url value="/inform/write.do" />" method="post">
                        <div class="mb-3">
                                <label for="iName">이름</label>
                                <input class="form-control" id="iName" name="iName" type="text" />
                            </div>
                            <div class="mb-3">
                                <label for="iRank">직책</label>
                                <input class="form-control" id="iRank" name="iRank" type="text" />
                            </div>
                        
                            <!-- title input-->
                            <div class="mb-3">
                                <label for="iTitle">제목</label>
                                <input class="form-control" id="iTitle" name="iTitle" type="text" />
                            </div>
                            <!-- content input-->
                            <div class="mb-3">
                           <label for="iContents">내용</label>
                                <textarea class="iContents" name="iContents" style="height: 20rem"></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="iPwd">비밀번호</label>
                                <input class="iPwd" id="iPwd" name="iPwd" type="password" />
                            </div>
                            <!-- Submit Button-->
                            <button class="btn btn-primary btn-xl" type="submit">등록</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>

      
    </body>
</html>