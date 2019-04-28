<div class="static-sidebar-wrapper sidebar-default">
	<div class="static-sidebar">
		<div class="sidebar">
			<div class="widget">
				<div class="widget-body">
					<div class="userinfo">
						<div class="avatar">
							<img src="images/avatar_15.png" class="img-responsive img-circle">
						</div>
						<div class="info">
							<span class="username">Admin</span> <span class="useremail">admin@entromania.com</span>
						</div>
					</div>
				</div>
			</div>
			<div class="widget stay-on-collapse" id="widget-sidebar">
				<nav role="navigation" class="widget-body">
					<ul class="acc-menu">
						<li class="nav-separator"><span>Explore</span></li>
						<li><a href="Index.jsp"><i class="ti ti-home"></i><span>Dashboard</span></a></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									State</span></a>
							<ul class="acc-menu">
								<li><a href="add-state.jsp">Add State</a></li>
								<li><a
									href="<%=request.getContextPath()%>/insertState?flag=searchState">View
										State</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									City</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/cityCo?flag=loadstate">Add
										City</a></li>
								<li><a
									href="<%=request.getContextPath()%>/cityCo?flag=viewcity">View
										City</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									Stadium</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/stadiumCo?flag=loadstatecity">Add
										Stadium</a></li>
								<li><a
									href="<%=request.getContextPath()%>/stadiumCo?flag=viewstadium">View
										Stadium</a></li>
							</ul></li>
						<%-- <li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage Sports</span></a>
        	<ul class="acc-menu">
        		<li><a href="addSport.jsp">Add Sports</a></li>
        		<li><a href="<%=request.getContextPath()%>/sportCo?flag=viewsport">View Sports</a></li>
        	</ul>
        </li>
         <li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage Employee</span></a>
        	<ul class="acc-menu">
        		<li><a href="<%=request.getContextPath()%>/employeeCo?flag=loadssc">Add Employee</a></li>
        		<li><a href="<%=request.getContextPath()%>/employeeCo?flag=viewemployee">View Employee</a></li>
        	</ul>
        </li> --%>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									Sponsership</span></a>
							<ul class="acc-menu">
								<li><a href="add-sponsership.jsp">Add Sponser</a></li>
								<li><a
									href="<%=request.getContextPath()%>/SponserCo?flag=viewSponser">View
										Sponser</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									Concert</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/concertCo?flag=loadstadium">Add
										Concert</a></li>
								<li><a
									href="<%=request.getContextPath()%>/concertCo?flag=viewconcert">View
										Concert</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									Match</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/matchCo?flag=loadstadium">Add
										Match</a></li>
								<li><a
									href="<%=request.getContextPath()%>/matchCo?flag=viewmatch">View
										Match</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									Heroes</span></a>
							<ul class="acc-menu">
								<li><a href="addHero.jsp">Add Heroes</a></li>
								<li><a
									href="<%=request.getContextPath()%>/HeroesCo?flag=viewHero">View
										Heroes</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Update
									Match Score</span></a>
							<ul class="acc-menu">
								<li><a href="update-score.jsp">Update Match Score</a></li>
								<li><a href="ui-advancedpanels.html">Search Score</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Cricket
									Tickets</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/ticketCo?flag=loadsm">Add
										Ticket</a></li>
								<li><a
									href="<%=request.getContextPath()%>/ticketCo?flag=viewticket">View
										Ticket</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Concert
									Tickets</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/conticketCo?flag=loadsc">Add
										Ticket</a></li>
								<li><a
									href="<%=request.getContextPath()%>/conticketCo?flag=viewcticket">View
										Ticket</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Shop
									Category</span></a>
							<ul class="acc-menu">
								<li><a href="addCategory.jsp">Add Category</a></li>
								<li><a
									href="<%=request.getContextPath()%>/CategoryCo?flag=viewCategory">View
										Category</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Shop
									Subcategory</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/SubCategoryCo?flag=loadCategory">Add
										SubCategory</a></li>
								<li><a
									href="<%=request.getContextPath()%>/SubCategoryCo?flag=viewSubCategory">View
										Subcategory</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Manage
									Product</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/ProductCo?flag=loadCatagorySubcategory">Add
										Product</a></li>
								<li><a
									href="<%=request.getContextPath()%>/ProductCo?flag=viewProduct">View
										Product</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Booked
									Ticket</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/bookticketCo?flag=viewbookedticket">View
										Booked Ticket</a></li>
							</ul></li>
						<li><a href="javascript:;"><i class="ti ti-view-list-alt"></i><span>Complain</span></a>
							<ul class="acc-menu">
								<li><a
									href="<%=request.getContextPath()%>/complainCo?flag=viewComplain">View
										Complain</a></li>
							</ul></li>


					</ul>
				</nav>
			</div>

		</div>
	</div>
</div>