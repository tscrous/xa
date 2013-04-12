<!-- Javascripts  -->
<script src="js/jquery.js"></script>
<script src="js/jquery.fitvids.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap-tab.js"></script>
<script src="js/bootstrap-transition.js"></script>
<script src="js/bootstrap-tooltip.js"></script>

<!-- Screen maximization via LOGO -->

<script type="text/javascript">
    $(document).ready(function(){
        $(".brand_large").click(function(){
            maximiseScreen(true);
            return false;
        });
        $(".brand_small").click(function(){
            maximiseScreen(false);
            return false;
        });
    });

    var maximiseScreen = function(maximise){
        if (maximise) {
            $(".navbar").hide();
            $(".topnav").css('border-bottom-color','#FFE0BF')
            $(".brand_small").show();
            $(".main-menu-alt").show();
        } else {
            $(".main-menu-alt").hide();
            $(".brand_small").hide();
            $(".topnav").css('border-bottom-color','#404040')
            $(".navbar").show();
        }
    }
</script>

<script>
    $.fn.extend({ 
        disableSelection: function() { 
            this.each(function() { 
                if (typeof this.onselectstart != 'undefined') {
                    this.onselectstart = function() { return false; };
                } else if (typeof this.style.MozUserSelect != 'undefined') {
                    this.style.MozUserSelect = 'none';
                } else {
                    this.onmousedown = function() { return false; };
                }
            }); 
        } 
    });

    $(document).ready(function() {
        $('.option-content').disableSelection();            
        $('.option-stats').disableSelection();            
    });
</script>

<script type="text/javascript">
    $(document).ready(function(){
        $(".brand_large").click(function(){
            maximiseScreen(true);
            return false;
        });
        $(".brand_small").click(function(){
            maximiseScreen(false);
            return false;
        });
    });

    var maximiseScreen = function(maximise){
        if (maximise) {
            $(".navbar").hide();
            $(".topnav").css('border-bottom-color','#FFE0BF')
            $(".brand_small").show();
            $(".main-menu-alt").show();
        } else {
            $(".main-menu-alt").hide();
            $(".brand_small").hide();
            $(".topnav").css('border-bottom-color','#404040')
            $(".navbar").show();
        }
    }
</script>

<script type="text/javascript">
    $(document).ready(function(){
        $(".option-container").click(function(){
            $(".option-container").removeClass('option-container-selected');
            $(this).addClass("option-container-selected");
            return false;
        });
        $(".option-container .option-exit a").click(function(){
            $(".option-container").removeClass('option-container-selected');
            return false;
        });

        $(".option-container").hover(function(){
            $(".option-container").removeClass('option-container-hover');
            $(this).addClass("option-container-hover");
            return false;
        }, function () {
            $(".option-container").removeClass('option-container-hover');
            return false;
        });
    });
</script>
