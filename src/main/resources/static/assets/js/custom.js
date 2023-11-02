/*  jQuery Nice Select - v1.0
    https://github.com/hernansartorio/jquery-nice-select
    Made by Hernán Sartorio  */
!function (e) { e.fn.niceSelect = function (t) { function s(t) { t.after(e("<div></div>").addClass("nice-select").addClass(t.attr("class") || "").addClass(t.attr("disabled") ? "disabled" : "").attr("tabindex", t.attr("disabled") ? null : "0").html('<span class="current"></span><ul class="list"></ul>')); var s = t.next(), n = t.find("option"), i = t.find("option:selected"); s.find(".current").html(i.data("display") || i.text()), n.each(function (t) { var n = e(this), i = n.data("display"); s.find("ul").append(e("<li></li>").attr("data-value", n.val()).attr("data-display", i || null).addClass("option" + (n.is(":selected") ? " selected" : "") + (n.is(":disabled") ? " disabled" : "")).html(n.text())) }) } if ("string" == typeof t) return "update" == t ? this.each(function () { var t = e(this), n = e(this).next(".nice-select"), i = n.hasClass("open"); n.length && (n.remove(), s(t), i && t.next().trigger("click")) }) : "destroy" == t ? (this.each(function () { var t = e(this), s = e(this).next(".nice-select"); s.length && (s.remove(), t.css("display", "")) }), 0 == e(".nice-select").length && e(document).off(".nice_select")) : console.log('Method "' + t + '" does not exist.'), this; this.hide(), this.each(function () { var t = e(this); t.next().hasClass("nice-select") || s(t) }), e(document).off(".nice_select"), e(document).on("click.nice_select", ".nice-select", function (t) { var s = e(this); e(".nice-select").not(s).removeClass("open"), s.toggleClass("open"), s.hasClass("open") ? (s.find(".option"), s.find(".focus").removeClass("focus"), s.find(".selected").addClass("focus")) : s.focus() }), e(document).on("click.nice_select", function (t) { 0 === e(t.target).closest(".nice-select").length && e(".nice-select").removeClass("open").find(".option") }), e(document).on("click.nice_select", ".nice-select .option:not(.disabled)", function (t) { var s = e(this), n = s.closest(".nice-select"); n.find(".selected").removeClass("selected"), s.addClass("selected"); var i = s.data("display") || s.text(); n.find(".current").text(i), n.prev("select").val(s.data("value")).trigger("change") }), e(document).on("keydown.nice_select", ".nice-select", function (t) { var s = e(this), n = e(s.find(".focus") || s.find(".list .option.selected")); if (32 == t.keyCode || 13 == t.keyCode) return s.hasClass("open") ? n.trigger("click") : s.trigger("click"), !1; if (40 == t.keyCode) { if (s.hasClass("open")) { var i = n.nextAll(".option:not(.disabled)").first(); i.length > 0 && (s.find(".focus").removeClass("focus"), i.addClass("focus")) } else s.trigger("click"); return !1 } if (38 == t.keyCode) { if (s.hasClass("open")) { var l = n.prevAll(".option:not(.disabled)").first(); l.length > 0 && (s.find(".focus").removeClass("focus"), l.addClass("focus")) } else s.trigger("click"); return !1 } if (27 == t.keyCode) s.hasClass("open") && s.trigger("click"); else if (9 == t.keyCode && s.hasClass("open")) return !1 }); var n = document.createElement("a").style; return n.cssText = "pointer-events:auto", "auto" !== n.pointerEvents && e("html").addClass("no-csspointerevents"), this } }(jQuery);
$(document).ready(function () {
  /********* On scroll heder Sticky *********/
  $(window).scroll(function () {
    var scroll = $(window).scrollTop();
    if (scroll >= 50) {
      $("header").addClass("head-sticky");
    } else {
      $("header").removeClass("head-sticky");
    }
  });
  /********* Mobile Menu ********/
  $('.mobile-menu-button').on('click', function (e) {
    e.preventDefault();
    setTimeout(function () {
      $('body').addClass('no-scroll active-menu');
      $(".mobile-menu-wrapper").toggleClass("active-menu");
      $('.overlay').addClass('menu-overlay');
    }, 50);
  });
  $('body').on('click', '.overlay.menu-overlay, .menu-close-icon svg', function (e) {
    e.preventDefault();
    $('body').removeClass('no-scroll active-menu');
    $(".mobile-menu-wrapper").removeClass("active-menu");
    $('.overlay').removeClass('menu-overlay');
  });
  /********* Cart Popup ********/
  $('.cart-header').on('click', function (e) {
    e.preventDefault();
    setTimeout(function () {
      $('body').addClass('no-scroll cartOpen');
      $('.overlay').addClass('cart-overlay');
    }, 50);
  });
  $('body').on('click', '.overlay.cart-overlay, .closecart', function (e) {
    e.preventDefault();
    $('.overlay').removeClass('cart-overlay');
    $('body').removeClass('no-scroll cartOpen');
  });
  /********* Mobile Filter Popup ********/
  $('.filter-title').on('click', function (e) {
    e.preventDefault();
    setTimeout(function () {
      $('body').addClass('no-scroll filter-open');
      $('.overlay').addClass('active');
    }, 50);
  });
  $('body').on('click', '.overlay.active, .close-filter', function (e) {
    e.preventDefault();
    $('.overlay').removeClass('active');
    $('body').removeClass('no-scroll filter-open');
  });
  /******* Cookie Js *******/
  $('.cookie-close').click(function () {
    $('.cookie').slideUp();
  });
  /******* Subscribe popup Js *******/
  $('.close-sub-btn').click(function () {
    $('.subscribe-popup').slideUp();
    $(".subscribe-overlay").removeClass("open");
  });
  /********* qty spinner ********/
  var quantity = 0;
  $('.quantity-increment').click(function () {
    ;
    var t = $(this).siblings('.quantity');
    var quantity = parseInt($(t).val());
    $(t).val(quantity + 1);
  });
  $('.quantity-decrement').click(function () {
    var t = $(this).siblings('.quantity');
    var quantity = parseInt($(t).val());
    if (quantity > 1) {
      $(t).val(quantity - 1);
    }
  });
  /******  Nice Select  ******/
  //$('select').niceSelect();
  /*********  Multi-level accordion nav  ********/
  $('.acnav-label').click(function () {
    var label = $(this);
    var parent = label.parent('.has-children');
    var list = label.siblings('.acnav-list');
    if (parent.hasClass('is-open')) {
      list.slideUp('fast');
      parent.removeClass('is-open');
    }
    else {
      list.slideDown('fast');
      parent.addClass('is-open');
    }
  });
  /****  TAB Js ****/
  $('ul.tabs li').click(function () {
    var $this = $(this);
    var $theTab = $(this).attr('data-tab');
    console.log($theTab);
    if ($this.hasClass('active')) {
      // do nothing
    } else {
      $this.closest('.tabs-wrapper').find('ul.tabs li, .tabs-container .tab-content').removeClass('active');
      $('.tabs-container .tab-content[id="' + $theTab + '"], ul.tabs li[data-tab="' + $theTab + '"]').addClass('active');
    }
    $('.tab-slider').slick('refresh');
  });
  $('.tab-slider').slick({
    slidesToShow: 4,
    slidesToScroll: 1,
    arrows: true,
    speed: 1000,
    dots: false,
    loop: true,
    infinite: true,
    responsive: [
      {
        breakpoint: 991,
        settings: {
          slidesToShow: 3,
        },
      },
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 500,
        settings: {
          slidesToShow: 1,
        },
      }
    ],
  });
  // testimonials-main
  $('.testimonials-main').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: true,
    speed: 1200,
    dots: false,
    loop: true,
    infinite: true,
    centerMode: true,
    responsive: [
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 500,
        settings: {
          slidesToShow: 1,
        },
      }
    ],
  });
  // blog-slider
  $('.blog-slider').slick({
    slidesToShow: 3,
    slidesToScroll: 1,
    arrows: true,
    speed: 1200,
    dots: false,
    loop: true,
    infinite: true,
    responsive: [
      {
        breakpoint: 991,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 500,
        settings: {
          slidesToShow: 1,
        },
      }
    ],
  });
  // pro-categorie-slider
  $('.pro-categorie-slider').slick({
    slidesToShow: 4,
    slidesToScroll: 1,
    arrows: true,
    speed: 1200,
    dots: false,
    loop: true,
    infinite: true,
    responsive: [
      {
        breakpoint: 991,
        settings: {
          slidesToShow: 3,
        },
      },
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 420,
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  });
  // blog-slider2
  $('.blog-slider2').slick({
    slidesToShow: 4,
    slidesToScroll: 1,
    arrows: true,
    speed: 1200,
    dots: false,
    loop: true,
    infinite: true,
    responsive: [
      {
        breakpoint: 991,
        settings: {
          slidesToShow: 3,
        },
      },
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 420,
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  });
  $('.right-slider').slick({
    dots: false,
    infinite: true,
    speed: 1000,
    loop: true,
    arrows: true,
    slidesToShow: 1,
    fade: true,
    cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)',
    touchThreshold: 100,
  });

});
if ($(".my-acc-column").length > 0) {
  jQuery(function ($) {
    var topMenuHeight = $("#daccount-nav").outerHeight();
    $("#account-nav").menuScroll(topMenuHeight);
    $(".account-list li:first-child").addClass("active");
  });
  // COPY THE FOLLOWING FUNCTION INTO ANY SCRIPTS
  jQuery.fn.extend({
    menuScroll: function (offset) {
      // Declare all global variables
      var topMenu = this;
      var topOffset = offset ? offset : 0;
      var menuItems = $(topMenu).find("a");
      var lastId;
      // Save all menu items into scrollItems array
      var scrollItems = $(menuItems).map(function () {
        var item = $($(this).attr("href"));
        if (item.length) {
          return item;
        }
      });
      // When the menu item is clicked, get the #id from the href value, then scroll to the #id element
      $(topMenu).on("click", "a", function (e) {
        var href = $(this).attr("href");
        var offsetTop = href === "#" ? 0 : $(href).offset().top - topOffset;
        function checkWidth() {
          var windowSize = $(window).width();
          if (windowSize <= 767) {
            $('html, body').stop().animate({
              scrollTop: offsetTop - 200
            }, 300);
          }
          else {
            $('html, body').stop().animate({
              scrollTop: offsetTop - 100
            }, 300);
          }
        }
        // Execute on load
        checkWidth();
        // Bind event listener
        $(window).resize(checkWidth);
        e.preventDefault();
      });
      // When page is scrolled
      $(window).scroll(function () {
        function checkWidth() {
          var windowSize = $(window).width();
          if (windowSize <= 767) {
            var nm = $("html").scrollTop();
            var nw = $("body").scrollTop();
            var fromTop = (nm > nw ? nm : nw) + topOffset;
            // When the page pass one #id section, return all passed sections to scrollItems and save them into new array current
            var current = $(scrollItems).map(function () {
              if ($(this).offset().top - 250 <= fromTop)
                return this;
            });
            // Get the most recent passed section from current array
            current = current[current.length - 1];
            var id = current && current.length ? current[0].id : "";
            if (lastId !== id) {
              lastId = id;
              // Set/remove active class
              $(menuItems)
                .parent().removeClass("active")
                .end().filter("[href='#" + id + "']").parent().addClass("active");
            }
          }
          else {
            var nm = $("html").scrollTop();
            var nw = $("body").scrollTop();
            var fromTop = (nm > nw ? nm : nw) + topOffset;
            // When the page pass one #id section, return all passed sections to scrollItems and save them into new array current
            var current = $(scrollItems).map(function () {
              if ($(this).offset().top <= fromTop)
                return this;
            });
            // Get the most recent passed section from current array
            current = current[current.length - 1];
            var id = current && current.length ? current[0].id : "";
            if (lastId !== id) {
              lastId = id;
              // Set/remove active class
              $(menuItems)
                .parent().removeClass("active")
                .end().filter("[href='#" + id + "']").parent().addClass("active");
            }
          }
        }
        // Execute on load
        checkWidth();
        // Bind event listener
        $(window).resize(checkWidth);
      });
    }
  });
}
$(window).on('load resize orientationchange', function () {
  /********* Wrapper top space ********/
  var header_hright = $('header').outerHeight();
  $('header').next('.wrapper').css('margin-top', header_hright + 'px');
});
$(document).ready(function () {
  // HOME BANNER SLIDER JS END // 
  $('.heading-slider-main').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: false,
    asNavFor: '.home-right-slider, .home-left-slider, .heading-slider-main',
    speed: 1000,
    dots: false,
    loop: true,
    infinite: true,
  });
  $('.home-left-slider').slick({
    dots: false,
    infinite: true,
    speed: 1000,
    loop: true,
    arrows: true,
    slidesToShow: 1,
    asNavFor: '.home-right-slider, .home-left-slider, .heading-slider-main',
  });
  var $slider = $('.home-right-slider');
  var $progressBar = $('.progress');
  var $progressBarLabel = $('.slider__label');
  $slider.on('beforeChange', function (event, slick, currentSlide, nextSlide) {
    var calc = ((nextSlide) / (slick.slideCount - 1)) * 100;
    $progressBar
      .css('background-size', calc + '% 100%')
      .attr('aria-valuenow', calc);
    $progressBarLabel.text(calc + '% completed');
  });
  $slider.slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: false,
    asNavFor: '.home-right-slider, .home-left-slider, .heading-slider-main',
    speed: 1000,
    dots: false,
    loop: true,
    infinite: true,
    responsive: [
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 2,
          arrows: true,
        },
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          arrows: true,
        },
      }
    ],
  });
});
$(document).ready(function () {
  var $slider = $('.pdp-slider-inner');
  var $progressBar = $('.progress');
  var $progressBarLabel = $('.slider__label');
  $slider.on('beforeChange', function (event, slick, currentSlide, nextSlide) {
    var calc = ((nextSlide) / (slick.slideCount - 1)) * 100;
    $progressBar
      .css('background-size', calc + '% 100%')
      .attr('aria-valuenow', calc);
    $progressBarLabel.text(calc + '% completed');
  });
  $slider.slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: false,
    speed: 1200,
    dots: false,
    loop: true,
    infinite: true,
    responsive: [
      {
        breakpoint: 768,
        settings: {
          arrows: true,
        },
      }
    ],
  });
});
var $slider = $('.pdp-slider-inner, .home-right-slider');
if ($slider.length) {
  var currentSlide;
  var slidesCount;
  var sliderCounter = document.createElement('div');
  sliderCounter.classList.add('slider__counter');
  var updateSliderCounter = function (slick, currentIndex) {
    currentSlide = slick.slickCurrentSlide() + 1;
    slidesCount = slick.slideCount;
    $(sliderCounter).text('0' + currentSlide + '-' + '0' + slidesCount)
  };
  $slider.on('init', function (event, slick) {
    $slider.append(sliderCounter);
    updateSliderCounter(slick);
  });
  $slider.on('afterChange', function (event, slick, currentSlide) {
    updateSliderCounter(slick, currentSlide);
  });
}
var $status = $('.pagingInfo');
var $slickElement = $('.slideshow');
$slickElement.on('init reInit afterChange', function (event, slick, currentSlide, nextSlide) {
  //currentSlide is undefined on init -- set it to 0 in this case (currentSlide is 0 based)
  var i = (currentSlide ? currentSlide : 0) + 1;
  $status.text(i + '/' + slick.slideCount);
}); 

/******  STEPPY FORM  CSS  ******/
var totalSteps = $(".steps li").length;
$(".submit").on("click", function(){
  return false; 
});

$(".steps li:nth-of-type(1)").addClass("active");
$(".myContainer .step-container:nth-of-type(1)").addClass("active");

$(".step-container").on("click", ".next", function() { 
  $(".steps li").eq($(this).parents(".step-container").index() + 1).addClass("active"); 
  $(this).parents(".step-container").removeClass("active").next().addClass("active"); 
  $('.right-slider').slick('refresh');  
});

$(".step-container").on("click", ".back", function() {  
  $(".steps li").eq($(this).parents(".step-container").index() - totalSteps).removeClass("active"); 
  $(this).parents(".step-container").removeClass("active").prev().addClass("active"); 
  $('.right-slider').slick('refresh');
});

// Add a click event listener to the icon
document.getElementById("search-button-service").addEventListener("click", function() {
  // Get the input element
  const inputElement = document.querySelector(".search-input");

  let searchValue = inputElement.value;
  if (searchValue === null || searchValue.trim() === "") {
    searchValue = "";
  }
  console.log(searchValue);

// Clear existing service cards
  const serviceContainer = document.getElementById("service-card");
  serviceContainer.innerHTML = ''; // Remove all child elements
  $.ajax({
    type: "GET",
    url: "/service/search?serviceName=" + searchValue, // Replace with the actual URL to your endpoint
    dataType: "json",
    success: function (data) {
      for (var service of data.content){
        console.log(service);
        renderService(service);
      }

      // Add event listeners to each button
      $(document).on('click', '#selectServiceBtn', function () {
        var serviceName = $(this).closest('.product-card-content').find('h4').text().trim();
        sessionStorage.setItem('selectedServiceName', serviceName);
        var serviceID = $(this).closest('.product-card-content').find('.service-id').text().trim(); // Get serviceID
        sessionStorage.setItem('selectedServiceID', serviceID); // Save serviceID to sessionStorage
        window.location.href = "/studio";
      });
    },
    error: function (xhr, status, error) {
      console.error("Error fetching service: " + error);
    }
  });
});
function renderService(search_service) {
  var service_template = $("#service-card_template").html();
  service_template = service_template.replace("{{imgSrc}}", search_service.linkImage);
  service_template = service_template.replace("{{serviceName}}", search_service.serviceName);
  service_template = service_template.replace("{{serviceID}}", search_service.serviceID);
  var added_service = $("#service-card");
  $(service_template).appendTo(added_service);
}


document.getElementById("search-button-studio").addEventListener("click", function() {
  // Get the input element
  const inputElement = document.querySelector(".search-input");

  let searchValue = inputElement.value;
  if (searchValue === null || searchValue.trim() === "") {
    searchValue = "";
  }
  console.log(searchValue);

// Clear existing service cards
  const studioContainer = document.getElementById("studio-card");
  studioContainer.innerHTML = ''; // Remove all child elements
  $.ajax({
    type: "GET",
    url: "/service/search?studioName=" + searchValue, // Replace with the actual URL to your endpoint
    dataType: "json",
    success: function (data) {
      for (var studio of data.content){
        console.log(studio);
        renderStudio(studio);
      }

      // Add event listeners to each button
      $(document).on('click', '#view-studio-btn', function () {
        var studioName = $(this).closest('.product-card-content').find('h4').text().trim();
        var studioID = $(this).closest('.product-card-content').find('.studio-id').text().trim(); // Get studioID
        sessionStorage.setItem('selectedStudioID', studioID); // Save studioID to sessionStorage
        sessionStorage.setItem('selectedStudioName', studioName);
        window.location.href = 'view-studio.html';
      });
    },
    error: function (xhr, status, error) {
      console.error("Error fetching service: " + error);
    }
  });
});
function renderStudio(search_studio) {
  var studio_template = $("#studio-card_template").html();
  studio_template = studio_template.replace("{{imgSrc}}", search_studio.bannerImg);
  studio_template = studio_template.replace("{{studioName}}", search_studio.studioName);
  studio_template = studio_template.replace("{{briefInfo}}", search_studio.briefInfo);
  studio_template = studio_template.replace("{{studioID}}", search_studio.studioID); // Add studioID
  var added_studio = $("#studio-card");
  $(studio_template).appendTo(added_studio);
}
/******  STEPPY FORM  CSS  End******/

