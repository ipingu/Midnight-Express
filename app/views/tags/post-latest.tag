<div class="sub-content">
	<h2>- latest -</h2>

#{list items: models.Post.findLatest(5), as:'post'}
	<ul>
		<li>
			#{a @Blog.displayById(post.id)}${post.title}#{/a}
		</li>
	</ul>
#{/list}

</div>