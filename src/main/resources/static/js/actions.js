const followButton = document.getElementById('follow-btn')
const likeButton = document.getElementById('like-btn')
const commentButton = document.getElementById('comment-btn')

 function followUser() {
     followButton.addEventListener('submit', function (evt){
         evt.preventDefault();
         alert("The button was clicked!");
     })
 }

function likePost() {
    alert("The button was clicked!");
}

function comment() {
}