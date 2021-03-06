<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>YourMeals</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
<link rel="shortcut icon"
  href="<%=request.getContextPath() %>/test/img/favicon.ico"
  type="image/x-icon">
<link rel="apple-touch-icon"
  href="<%=request.getContextPath() %>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
  href="<%=request.getContextPath() %>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
  href="<%=request.getContextPath() %>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath() %>/test/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath() %>/test/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath() %>/test/css/style.css">
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath() %>/test/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath() %>/test/css/nivo-lightbox/default.css">
<link
  href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700"
  rel="stylesheet">
<link
  href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
  rel="stylesheet">
<link
  href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700"
  rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
  <header><jsp:include page="/header.jsp"></jsp:include></header>
  <!-- Header -->
  <header id="header">
    <div class="intro">
      <div class="overlay">
        <div class="container">
          <div class="row">
            <div class="intro-text">
              <h1>YourMeals</h1>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- About Section -->
  <div id="about">
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-md-6 ">
          <div class="about-img">
            <img src="<%=request.getContextPath() %>/test/img/about.jpg"
              class="img-responsive" alt="">
          </div>
        </div>
        <div class="col-xs-12 col-md-6">
          <div class="about-text">
            <h2>${first.title}</h2>
            <hr>
            <p>로렘입숨</p>
            <h3>재료</h3>
            <p>설명</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Restaurant Menu Section -->
  <div id="restaurant-menu">
    <div class="section-title text-center center">
      <div class="overlay">
        <h2>Menu</h2>
        <hr>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit duis
          sed.</p>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-6">
          <div class="menu-section">
            <h2 class="menu-section-title">Breakfast & Starters</h2>
            <hr>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$35</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
          </div>
        </div>
        <div class="col-xs-12 col-sm-6">
          <div class="menu-section">
            <h2 class="menu-section-title">Main Course</h2>
            <hr>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$45</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12 col-sm-6">
          <div class="menu-section">
            <h2 class="menu-section-title">Dinner</h2>
            <hr>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$45</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$350</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam..</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
          </div>
        </div>
        <div class="col-xs-12 col-sm-6">
          <div class="menu-section">
            <h2 class="menu-section-title">Coffee & Drinks</h2>
            <hr>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$35</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
            <div class="menu-item">
              <div class="menu-item-name">Delicious Dish</div>
              <div class="menu-item-price">$30</div>
              <div class="menu-item-description">Lorem ipsum dolor sit
                amet, consectetur adipiscing elit, duis sed dapibus leo nec
                ornare diam.</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Portfolio Section -->
  <div id="portfolio">
    <div class="section-title text-center center">
      <div class="overlay">
        <h2>Gallery</h2>
        <hr>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit duis
          sed.</p>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="categories">
          <ul class="cat">
            <li>
              <ol class="type">
                <li><a href="#" data-filter="*" class="active">All</a></li>
                <li><a href="#" data-filter=".breakfast">Breakfast</a></li>
                <li><a href="#" data-filter=".lunch">Lunch</a></li>
                <li><a href="#" data-filter=".dinner">Dinner</a></li>
              </ol>
            </li>
          </ul>
          <div class="clearfix"></div>
        </div>
      </div>
      <div class="row">
        <div class="portfolio-items">
          <div class="col-sm-6 col-md-4 col-lg-4 breakfast">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/01-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/01-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 dinner">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/02-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/02-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 breakfast">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/03-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/03-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 breakfast">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/04-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/04-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 dinner">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/05-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/05-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 lunch">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/06-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/06-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 lunch">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/07-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/07-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 breakfast">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/08-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/08-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 dinner">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/09-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/09-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 lunch">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/10-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/10-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 lunch">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/11-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/11-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-4 breakfast">
            <div class="portfolio-item">
              <div class="hover-bg">
                <a
                  href="<%=request.getContextPath() %>/test/img/portfolio/12-large.jpg"
                  title="Dish Name" data-lightbox-gallery="gallery1">
                  <div class="hover-text">
                    <h4>Dish Name</h4>
                  </div> <img
                  src="<%=request.getContextPath() %>/test/img/portfolio/12-small.jpg"
                  class="img-responsive" alt="Project Title">
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Team Section -->
  <div id="team" class="text-center">
    <div class="overlay">
      <div class="container">
        <div class="col-md-10 col-md-offset-1 section-title">
          <h2>Meet Our Chefs</h2>
          <hr>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit duis
            sed dapibus leonec.</p>
        </div>
        <div id="row">
          <div class="col-md-4 team">
            <div class="thumbnail">
              <div class="team-img">
                <img src="<%=request.getContextPath() %>/test/img/team/01.jpg"
                  alt="...">
              </div>
              <div class="caption">
                <h3>Mike Doe</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Duis sed dapibus leo nec ornare diam.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 team">
            <div class="thumbnail">
              <div class="team-img">
                <img src="<%=request.getContextPath() %>/test/img/team/02.jpg"
                  alt="...">
              </div>
              <div class="caption">
                <h3>Chris Doe</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Duis sed dapibus leo nec ornare diam.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 team">
            <div class="thumbnail">
              <div class="team-img">
                <img src="<%=request.getContextPath() %>/test/img/team/03.jpg"
                  alt="...">
              </div>
              <div class="caption">
                <h3>Ethan Doe</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Duis sed dapibus leo nec ornare diam.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Call Reservation Section -->
  <div id="call-reservation" class="text-center">
    <div class="container">
      <h2>
        Want to make a reservation? Call <strong>1-887-654-3210</strong>
      </h2>
    </div>
  </div>
  <!-- Contact Section -->
  <div id="contact" class="text-center">
    <div class="container">
      <div class="section-title text-center">
        <h2>Contact Form</h2>
        <hr>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit duis
          sed.</p>
      </div>
      <div class="col-md-10 col-md-offset-1">
        <form name="sentMessage" id="contactForm" novalidate>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input type="text" id="name" class="form-control"
                  placeholder="Name" required="required">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <input type="email" id="email" class="form-control"
                  placeholder="Email" required="required">
                <p class="help-block text-danger"></p>
              </div>
            </div>
          </div>
          <div class="form-group">
            <textarea name="message" id="message" class="form-control"
              rows="4" placeholder="Message" required></textarea>
            <p class="help-block text-danger"></p>
          </div>
          <div id="success"></div>
          <button type="submit" class="btn btn-custom btn-lg">Send
            Message</button>
        </form>
      </div>
    </div>
  </div>

  <div id="signup" class="text-center">



    <div id="footer">
      <div class="container text-center">
        <div class="col-md-4">
          <h3>Address</h3>
          <div class="contact-item">
            <p>4321 California St,</p>
            <p>San Francisco, CA 12345</p>
          </div>
        </div>
        <div class="col-md-4">
          <h3>Opening Hours</h3>
          <div class="contact-item">
            <p>Mon-Thurs: 10:00 AM - 11:00 PM</p>
            <p>Fri-Sun: 11:00 AM - 02:00 AM</p>
          </div>
        </div>
        <div class="col-md-4">
          <h3>Contact Info</h3>
          <div class="contact-item">
            <p>Phone: +1 123 456 1234</p>
            <p>Email: info@company.com</p>
          </div>
        </div>
      </div>
      <div class="container-fluid text-center copyrights">
        <div class="col-md-8 col-md-offset-2">
          <p>
            <br> Copyright ©YourMeals Inc. All Rights Reserved <i
              class="fa fa-love"></i><a href="https://bootstrapthemes.co"></a>
          </p>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/jquery.1.11.1.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/bootstrap.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/SmoothScroll.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/nivo-lightbox.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/jquery.isotope.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/jqBootstrapValidation.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/contact_me.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/main.js"></script>
</body>
</html>
