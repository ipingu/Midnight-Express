<div class="sub-content">
	<h2>${_post.title}
	<span class="sub-content-info">posted at ${_post.creation?.format('dd MM yyyy')}</span>
	</h2>
	#{if _style != 'resume'}
		<div>${_post.content}</div>
	#{/if}
	
	#{if _style == 'resume'}
		<div>
			${_post.content[0..(_post.content.size() > 550 ? 550 : _post.content.size() - 1)]}
			
			<hr class="space" />
			<a href="@{Blog.displayByTitle(_post.title)}">- show full post -</a>
			<span>${_post.comments.size()} comments</span>
		</div>
	#{/if}
</div>