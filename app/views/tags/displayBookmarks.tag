<ul>
	#{list items:_bookmarks, as:'bookmark'}
	<li>#${bookmark.id} - <a href="${bookmark.url}">${bookmark.title}</a></li>
	#{/list}	
</ul>