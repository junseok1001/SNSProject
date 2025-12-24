package com.sourjelly.snsproject.main.service;

import com.sourjelly.snsproject.comment.domain.Comment;
import com.sourjelly.snsproject.comment.dto.CommentDto;
import com.sourjelly.snsproject.comment.service.CommentService;
import com.sourjelly.snsproject.common.FileManger;
import com.sourjelly.snsproject.comment.repository.CommentRepository;
import com.sourjelly.snsproject.like.service.LikeService;
import com.sourjelly.snsproject.main.Repository.MainRepository;
import com.sourjelly.snsproject.main.domain.Post;
import com.sourjelly.snsproject.main.dto.PostDto;
import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor // 필수 멤버 변수 를 생성자를 통해서 대응
@Service
public class MainService {

    private final MainRepository mainRepository;

    private final UserService userService;

    private final CommentService commentService;

    private final LikeService likeService;


    // 게시물 추가부터
    public boolean createPost(
            long userId
            , String title
            , String contents
            , MultipartFile imageFile){

        String imagePath = FileManger.saveFile(userId, imageFile);

        Post post = Post.builder()
                .userId(userId)
                .title(title)
                .contents(contents)
                .imagePath(imagePath)
                .build();

        try{
            mainRepository.save(post);
        }catch(DataAccessException e){
            return false;
        }

        return true;
    }


//     게시물 전체정보 가져오기
    public List<PostDto> PostList(long userId){

        List<Post> postList = mainRepository.findAll(Sort.by("id").descending());

        List<PostDto> postDtoList = new ArrayList<>();
        for(Post post: postList){
            // post -> postDto로 변환
            // 1 + N 문제 : cache로 극복

            User user = userService.getUserById(post.getUserId());
            int likeCount = likeService.countByPostId(post.getId());

            boolean isLike =likeService.isLikeByPostIdAndUserId(userId, post.getId());

            List<CommentDto> commentDtoList = commentService.getCommentsByPostId(post.getId());

            PostDto postDto = PostDto.builder()
                    .id(post.getId())
                    .contents(post.getContents())
                    .imagePath(post.getImagePath())
                    .userId(post.getUserId())
                    .name(user.getName())
                    .likeCount(likeCount)
                    .isLike(isLike)
                    .commentList(commentDtoList)
                    .build();
            postDtoList.add(postDto);

        }
        return postDtoList;
    }
    // post 하나의 수정내용
    public Post modifyPost(long postId){

        Optional<Post> optionalPost = mainRepository.findById(postId);

        if(optionalPost.isPresent()){
            return optionalPost.get();

        }else{
            return null;
        }
    }

    @Transactional
    public  boolean removePost(long id, long userId){

        Optional<Post> optionalPost =  mainRepository.findById(id);

        if(optionalPost.isPresent()){

            try{

                Post post = optionalPost.get();

                if(post.getUserId() != userId){
                    return false;
                }

                commentService.deleteCommentByPostId(post.getId());

                likeService.deleteLikeByPostId(post.getId());

                mainRepository.delete(post);

                FileManger.removeFile(post.getImagePath());
            }catch(DataAccessException e){
                return false;
            }

            return true;
        }else{
            return false;
        }


    }


}
