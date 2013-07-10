  


<!DOCTYPE html>
<html>
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# githubog: http://ogp.me/ns/fb/githubog#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>viewportSize/viewportSize-min.js at master · tysonmatanich/viewportSize · GitHub</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <link rel="logo" type="image/svg" href="http://github-media-downloads.s3.amazonaws.com/github-logo.svg" />
    <link rel="xhr-socket" href="/_sockets" />


    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" />

    
    
    <link rel="icon" type="image/x-icon" href="/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="nHWMw8zmo6NCRhPybvMfBgpyuh0IYi8RK8D4JHUk11s=" name="csrf-token" />

    <link href="https://a248.e.akamai.net/assets.github.com/assets/github-d63f89e307e2e357d3b7160b3cd4020463f9bbc1.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://a248.e.akamai.net/assets.github.com/assets/github2-883c2d036f95a0fb486a5d977a84cb0b91a58353.css" media="all" rel="stylesheet" type="text/css" />
    


      <script src="https://a248.e.akamai.net/assets.github.com/assets/frameworks-92d138f450f2960501e28397a2f63b0f100590f0.js" type="text/javascript"></script>
      <script src="https://a248.e.akamai.net/assets.github.com/assets/github-9514cee43c62b106e5ca1f5cf2107a0c1fad9381.js" type="text/javascript"></script>
      
      <meta http-equiv="x-pjax-version" content="69eecf449c3b66a1c0a67e6f1032684b">

        <link data-pjax-transient rel='permalink' href='/tysonmatanich/viewportSize/blob/ff30d834a5bef5fb4722cff72735a8a096f494c7/viewportSize-min.js'>
    <meta property="og:title" content="viewportSize"/>
    <meta property="og:type" content="githubog:gitrepository"/>
    <meta property="og:url" content="https://github.com/tysonmatanich/viewportSize"/>
    <meta property="og:image" content="https://secure.gravatar.com/avatar/09ec001e0fab1d59963a140f6e88f86b?s=420&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"/>
    <meta property="og:site_name" content="GitHub"/>
    <meta property="og:description" content="viewportSize - Get the size of the CSS viewport using JavaScript"/>
    <meta property="twitter:card" content="summary"/>
    <meta property="twitter:site" content="@GitHub">
    <meta property="twitter:title" content="tysonmatanich/viewportSize"/>

    <meta name="description" content="viewportSize - Get the size of the CSS viewport using JavaScript" />


    <meta content="2696475" name="octolytics-dimension-user_id" /><meta content="7281004" name="octolytics-dimension-repository_id" />
  <link href="https://github.com/tysonmatanich/viewportSize/commits/master.atom" rel="alternate" title="Recent Commits to viewportSize:master" type="application/atom+xml" />

  </head>


  <body class="logged_out page-blob macintosh vis-public env-production  ">
    <div id="wrapper">

      

      
      
      

      
      <div class="header header-logged-out">
  <div class="container clearfix">

    <a class="header-logo-wordmark" href="https://github.com/">Github</a>

    <div class="header-actions">
      <a class="button primary" href="https://github.com/signup">Sign up</a>
      <a class="button" href="https://github.com/login?return_to=%2Ftysonmatanich%2FviewportSize%2Fblob%2Fmaster%2FviewportSize-min.js">Sign in</a>
    </div>

    <div class="command-bar js-command-bar  in-repository">


      <ul class="top-nav">
          <li class="explore"><a href="https://github.com/explore">Explore</a></li>
        <li class="features"><a href="https://github.com/features">Features</a></li>
          <li class="blog"><a href="https://github.com/blog">Blog</a></li>
      </ul>
        <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">
  <a href="/search/advanced" class="advanced-search-icon tooltipped downwards command-bar-search" id="advanced_search" title="Advanced search"><span class="octicon octicon-gear "></span></a>

  <input type="text" data-hotkey="/ s" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
      data-repo="tysonmatanich/viewportSize"
      data-branch="master"
      data-sha="9a0fbe37ea1700b7dc0e23e54bbd4f661eef1ac7"
  >

    <input type="hidden" name="nwo" value="tysonmatanich/viewportSize" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="octicon help tooltipped downwards" title="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

  <div class="divider-vertical"></div>

</form>
    </div>

  </div>
</div>


      

      


            <div class="site hfeed" itemscope itemtype="http://schema.org/WebPage">
      <div class="hentry">
        
        <div class="pagehead repohead instapaper_ignore readability-menu ">
          <div class="container">
            <div class="title-actions-bar">
              

<ul class="pagehead-actions">



    <li>
      <a href="/login?return_to=%2Ftysonmatanich%2FviewportSize"
        class="minibutton js-toggler-target star-button entice tooltipped upwards"
        title="You must be signed in to use this feature" rel="nofollow">
        <span class="octicon octicon-star"></span>Star
      </a>
      <a class="social-count js-social-count" href="/tysonmatanich/viewportSize/stargazers">
        102
      </a>
    </li>
    <li>
      <a href="/login?return_to=%2Ftysonmatanich%2FviewportSize"
        class="minibutton js-toggler-target fork-button entice tooltipped upwards"
        title="You must be signed in to fork a repository" rel="nofollow">
        <span class="octicon octicon-git-branch"></span>Fork
      </a>
      <a href="/tysonmatanich/viewportSize/network" class="social-count">
        9
      </a>
    </li>
</ul>

              <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
                <span class="repo-label"><span>public</span></span>
                <span class="mega-octicon octicon-repo"></span>
                <span class="author vcard">
                  <a href="/tysonmatanich" class="url fn" itemprop="url" rel="author">
                  <span itemprop="title">tysonmatanich</span>
                  </a></span> /
                <strong><a href="/tysonmatanich/viewportSize" class="js-current-repository">viewportSize</a></strong>
              </h1>
            </div>

            
  <ul class="tabs">
    <li class="pulse-nav"><a href="/tysonmatanich/viewportSize/pulse" class="js-selected-navigation-item " data-selected-links="pulse /tysonmatanich/viewportSize/pulse" rel="nofollow"><span class="octicon octicon-pulse"></span></a></li>
    <li><a href="/tysonmatanich/viewportSize" class="js-selected-navigation-item selected" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /tysonmatanich/viewportSize">Code</a></li>
    <li><a href="/tysonmatanich/viewportSize/network" class="js-selected-navigation-item " data-selected-links="repo_network /tysonmatanich/viewportSize/network">Network</a></li>
    <li><a href="/tysonmatanich/viewportSize/pulls" class="js-selected-navigation-item " data-selected-links="repo_pulls /tysonmatanich/viewportSize/pulls">Pull Requests <span class='counter'>0</span></a></li>

      <li><a href="/tysonmatanich/viewportSize/issues" class="js-selected-navigation-item " data-selected-links="repo_issues /tysonmatanich/viewportSize/issues">Issues <span class='counter'>1</span></a></li>



    <li><a href="/tysonmatanich/viewportSize/graphs" class="js-selected-navigation-item " data-selected-links="repo_graphs repo_contributors /tysonmatanich/viewportSize/graphs">Graphs</a></li>


  </ul>
  
<div class="tabnav">

  <span class="tabnav-right">
    <ul class="tabnav-tabs">
          <li><a href="/tysonmatanich/viewportSize/tags" class="js-selected-navigation-item tabnav-tab" data-selected-links="repo_tags /tysonmatanich/viewportSize/tags">Tags <span class="counter blank">0</span></a></li>
    </ul>
  </span>

  <div class="tabnav-widget scope">


    <div class="select-menu js-menu-container js-select-menu js-branch-menu">
      <a class="minibutton select-menu-button js-menu-target" data-hotkey="w" data-ref="master">
        <span class="octicon octicon-branch"></span>
        <i>branch:</i>
        <span class="js-select-button">master</span>
      </a>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container">

        <div class="select-menu-modal">
          <div class="select-menu-header">
            <span class="select-menu-title">Switch branches/tags</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-filters">
            <div class="select-menu-text-filter">
              <input type="text" id="commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Filter branches/tags">
            </div>
            <div class="select-menu-tabs">
              <ul>
                <li class="select-menu-tab">
                  <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
                </li>
                <li class="select-menu-tab">
                  <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
                </li>
              </ul>
            </div><!-- /.select-menu-tabs -->
          </div><!-- /.select-menu-filters -->

          <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket css-truncate" data-tab-filter="branches">

            <div data-filterable-for="commitish-filter-field" data-filterable-type="substring">

                <div class="select-menu-item js-navigation-item ">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <a href="/tysonmatanich/viewportSize/blob/gh-pages/viewportSize-min.js" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="gh-pages" rel="nofollow" title="gh-pages">gh-pages</a>
                </div> <!-- /.select-menu-item -->
                <div class="select-menu-item js-navigation-item selected">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <a href="/tysonmatanich/viewportSize/blob/master/viewportSize-min.js" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="master" rel="nofollow" title="master">master</a>
                </div> <!-- /.select-menu-item -->
            </div>

              <div class="select-menu-no-results">Nothing to show</div>
          </div> <!-- /.select-menu-list -->


          <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket css-truncate" data-tab-filter="tags">
            <div data-filterable-for="commitish-filter-field" data-filterable-type="substring">

            </div>

            <div class="select-menu-no-results">Nothing to show</div>

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

  </div> <!-- /.scope -->

  <ul class="tabnav-tabs">
    <li><a href="/tysonmatanich/viewportSize" class="selected js-selected-navigation-item tabnav-tab" data-selected-links="repo_source /tysonmatanich/viewportSize">Files</a></li>
    <li><a href="/tysonmatanich/viewportSize/commits/master" class="js-selected-navigation-item tabnav-tab" data-selected-links="repo_commits /tysonmatanich/viewportSize/commits/master">Commits</a></li>
    <li><a href="/tysonmatanich/viewportSize/branches" class="js-selected-navigation-item tabnav-tab" data-selected-links="repo_branches /tysonmatanich/viewportSize/branches" rel="nofollow">Branches <span class="counter ">2</span></a></li>
  </ul>

</div>

  
  
  


            
          </div>
        </div><!-- /.repohead -->

        <div id="js-repo-pjax-container" class="container context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:84c82960051ee186bd922244068b9682 -->
<!-- blob contrib frag key: views10/v8/blob_contributors:v21:84c82960051ee186bd922244068b9682 -->


<div id="slider">
    <div class="frame-meta">

      <p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

        <div class="breadcrumb">
          <span class='bold'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/tysonmatanich/viewportSize" class="js-slide-to" data-branch="master" data-direction="back" itemscope="url"><span itemprop="title">viewportSize</span></a></span></span><span class="separator"> / </span><strong class="final-path">viewportSize-min.js</strong> <span class="js-zeroclipboard zeroclipboard-button" data-clipboard-text="viewportSize-min.js" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
        </div>

      <a href="/tysonmatanich/viewportSize/find/master" class="js-slide-to" data-hotkey="t" style="display:none">Show File Finder</a>


        <div class="commit commit-loader file-history-tease js-deferred-content" data-url="/tysonmatanich/viewportSize/contributors/master/viewportSize-min.js">
          Fetching contributors…

          <div class="participation">
            <p class="loader-loading"><img alt="Octocat-spinner-32-eaf2f5" height="16" src="https://a248.e.akamai.net/assets.github.com/images/spinners/octocat-spinner-32-EAF2F5.gif?1338945075" width="16" /></p>
            <p class="loader-error">Cannot retrieve contributors at this time</p>
          </div>
        </div>

    </div><!-- ./.frame-meta -->

    <div class="frames">
      <div class="frame" data-permalink-url="/tysonmatanich/viewportSize/blob/ff30d834a5bef5fb4722cff72735a8a096f494c7/viewportSize-min.js" data-title="viewportSize/viewportSize-min.js at master · tysonmatanich/viewportSize · GitHub" data-type="blob">

        <div id="files" class="bubble">
          <div class="file">
            <div class="meta">
              <div class="info">
                <span class="icon"><b class="octicon octicon-file-text"></b></span>
                <span class="mode" title="File Mode">file</span>
                  <span>2 lines (2 sloc)</span>
                <span>0.784 kb</span>
              </div>
              <div class="actions">
                <div class="button-group">
                      <a class="minibutton js-entice" href=""
                         data-entice="You must be signed in and on a branch to make or propose changes">Edit</a>
                  <a href="/tysonmatanich/viewportSize/raw/master/viewportSize-min.js" class="button minibutton " id="raw-url">Raw</a>
                    <a href="/tysonmatanich/viewportSize/blame/master/viewportSize-min.js" class="button minibutton ">Blame</a>
                  <a href="/tysonmatanich/viewportSize/commits/master/viewportSize-min.js" class="button minibutton " rel="nofollow">History</a>
                </div><!-- /.button-group -->
              </div><!-- /.actions -->

            </div>
                <div class="blob-wrapper data type-javascript js-blob-data">
      <table class="file-code file-diff">
        <tr class="file-code-line">
          <td class="blob-line-nums">
            <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>

          </td>
          <td class="blob-line-code">
                  <div class="highlight"><pre><div class='line' id='LC1'><span class="cm">/*! viewportSize | Author: Tyson Matanich, 2013 | License: MIT */</span></div><div class='line' id='LC2'><span class="p">(</span><span class="kd">function</span><span class="p">(</span><span class="nx">n</span><span class="p">){</span><span class="nx">n</span><span class="p">.</span><span class="nx">viewportSize</span><span class="o">=</span><span class="p">{},</span><span class="nx">n</span><span class="p">.</span><span class="nx">viewportSize</span><span class="p">.</span><span class="nx">getHeight</span><span class="o">=</span><span class="kd">function</span><span class="p">(){</span><span class="k">return</span> <span class="nx">t</span><span class="p">(</span><span class="s2">&quot;Height&quot;</span><span class="p">)},</span><span class="nx">n</span><span class="p">.</span><span class="nx">viewportSize</span><span class="p">.</span><span class="nx">getWidth</span><span class="o">=</span><span class="kd">function</span><span class="p">(){</span><span class="k">return</span> <span class="nx">t</span><span class="p">(</span><span class="s2">&quot;Width&quot;</span><span class="p">)};</span><span class="kd">var</span> <span class="nx">t</span><span class="o">=</span><span class="kd">function</span><span class="p">(</span><span class="nx">t</span><span class="p">){</span><span class="kd">var</span> <span class="nx">f</span><span class="p">,</span><span class="nx">o</span><span class="o">=</span><span class="nx">t</span><span class="p">.</span><span class="nx">toLowerCase</span><span class="p">(),</span><span class="nx">e</span><span class="o">=</span><span class="nx">n</span><span class="p">.</span><span class="nb">document</span><span class="p">,</span><span class="nx">i</span><span class="o">=</span><span class="nx">e</span><span class="p">.</span><span class="nx">documentElement</span><span class="p">,</span><span class="nx">r</span><span class="p">,</span><span class="nx">u</span><span class="p">;</span><span class="k">return</span> <span class="nx">n</span><span class="p">[</span><span class="s2">&quot;inner&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">]</span><span class="o">===</span><span class="kc">undefined</span><span class="o">?</span><span class="nx">f</span><span class="o">=</span><span class="nx">i</span><span class="p">[</span><span class="s2">&quot;client&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">]</span><span class="o">:</span><span class="nx">n</span><span class="p">[</span><span class="s2">&quot;inner&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">]</span><span class="o">!=</span><span class="nx">i</span><span class="p">[</span><span class="s2">&quot;client&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">]</span><span class="o">?</span><span class="p">(</span><span class="nx">r</span><span class="o">=</span><span class="nx">e</span><span class="p">.</span><span class="nx">createElement</span><span class="p">(</span><span class="s2">&quot;body&quot;</span><span class="p">),</span><span class="nx">r</span><span class="p">.</span><span class="nx">id</span><span class="o">=</span><span class="s2">&quot;vpw-test-b&quot;</span><span class="p">,</span><span class="nx">r</span><span class="p">.</span><span class="nx">style</span><span class="p">.</span><span class="nx">cssText</span><span class="o">=</span><span class="s2">&quot;overflow:scroll&quot;</span><span class="p">,</span><span class="nx">u</span><span class="o">=</span><span class="nx">e</span><span class="p">.</span><span class="nx">createElement</span><span class="p">(</span><span class="s2">&quot;div&quot;</span><span class="p">),</span><span class="nx">u</span><span class="p">.</span><span class="nx">id</span><span class="o">=</span><span class="s2">&quot;vpw-test-d&quot;</span><span class="p">,</span><span class="nx">u</span><span class="p">.</span><span class="nx">style</span><span class="p">.</span><span class="nx">cssText</span><span class="o">=</span><span class="s2">&quot;position:absolute;top:-1000px&quot;</span><span class="p">,</span><span class="nx">u</span><span class="p">.</span><span class="nx">innerHTML</span><span class="o">=</span><span class="s2">&quot;&lt;style&gt;@media(&quot;</span><span class="o">+</span><span class="nx">o</span><span class="o">+</span><span class="s2">&quot;:&quot;</span><span class="o">+</span><span class="nx">i</span><span class="p">[</span><span class="s2">&quot;client&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">]</span><span class="o">+</span><span class="s2">&quot;px){body#vpw-test-b div#vpw-test-d{&quot;</span><span class="o">+</span><span class="nx">o</span><span class="o">+</span><span class="s2">&quot;:7px!important}}&lt;\/style&gt;&quot;</span><span class="p">,</span><span class="nx">r</span><span class="p">.</span><span class="nx">appendChild</span><span class="p">(</span><span class="nx">u</span><span class="p">),</span><span class="nx">i</span><span class="p">.</span><span class="nx">insertBefore</span><span class="p">(</span><span class="nx">r</span><span class="p">,</span><span class="nx">e</span><span class="p">.</span><span class="nx">head</span><span class="p">),</span><span class="nx">f</span><span class="o">=</span><span class="nx">u</span><span class="p">[</span><span class="s2">&quot;offset&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">]</span><span class="o">==</span><span class="mi">7</span><span class="o">?</span><span class="nx">i</span><span class="p">[</span><span class="s2">&quot;client&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">]</span><span class="o">:</span><span class="nx">n</span><span class="p">[</span><span class="s2">&quot;inner&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">],</span><span class="nx">i</span><span class="p">.</span><span class="nx">removeChild</span><span class="p">(</span><span class="nx">r</span><span class="p">))</span><span class="o">:</span><span class="nx">f</span><span class="o">=</span><span class="nx">n</span><span class="p">[</span><span class="s2">&quot;inner&quot;</span><span class="o">+</span><span class="nx">t</span><span class="p">],</span><span class="nx">f</span><span class="p">}})(</span><span class="k">this</span><span class="p">);</span></div></pre></div>
          </td>
        </tr>
      </table>
  </div>

          </div>
        </div>

        <a href="#jump-to-line" rel="facebox" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
        <div id="jump-to-line" style="display:none">
          <h2>Jump to Line</h2>
          <form accept-charset="UTF-8" class="js-jump-to-line-form">
            <input class="textfield js-jump-to-line-field" type="text">
            <div class="full-button">
              <button type="submit" class="button">Go</button>
            </div>
          </form>
        </div>

      </div>
    </div>
</div>

<div id="js-frame-loading-template" class="frame frame-loading large-loading-area" style="display:none;">
  <img class="js-frame-loading-spinner" src="https://a248.e.akamai.net/assets.github.com/images/spinners/octocat-spinner-128.gif?1347543527" height="64" width="64">
</div>


        </div>
      </div>
      <div class="modal-backdrop"></div>
    </div>

      <div id="footer-push"></div><!-- hack for sticky footer -->
    </div><!-- end of wrapper - hack for sticky footer -->

      <!-- footer -->
      <div id="footer">
  <div class="container clearfix">

      <dl class="footer_nav">
        <dt>GitHub</dt>
        <dd><a href="https://github.com/about">About us</a></dd>
        <dd><a href="https://github.com/blog">Blog</a></dd>
        <dd><a href="https://github.com/contact">Contact &amp; support</a></dd>
        <dd><a href="http://enterprise.github.com/">GitHub Enterprise</a></dd>
        <dd><a href="http://status.github.com/">Site status</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>Applications</dt>
        <dd><a href="http://mac.github.com/">GitHub for Mac</a></dd>
        <dd><a href="http://windows.github.com/">GitHub for Windows</a></dd>
        <dd><a href="http://eclipse.github.com/">GitHub for Eclipse</a></dd>
        <dd><a href="http://mobile.github.com/">GitHub mobile apps</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>Services</dt>
        <dd><a href="http://get.gaug.es/">Gauges: Web analytics</a></dd>
        <dd><a href="http://speakerdeck.com">Speaker Deck: Presentations</a></dd>
        <dd><a href="https://gist.github.com">Gist: Code snippets</a></dd>
        <dd><a href="http://jobs.github.com/">Job board</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>Documentation</dt>
        <dd><a href="http://help.github.com/">GitHub Help</a></dd>
        <dd><a href="http://developer.github.com/">Developer API</a></dd>
        <dd><a href="http://github.github.com/github-flavored-markdown/">GitHub Flavored Markdown</a></dd>
        <dd><a href="http://pages.github.com/">GitHub Pages</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>More</dt>
        <dd><a href="http://training.github.com/">Training</a></dd>
        <dd><a href="https://github.com/edu">Students &amp; teachers</a></dd>
        <dd><a href="http://shop.github.com">The Shop</a></dd>
        <dd><a href="/plans">Plans &amp; pricing</a></dd>
        <dd><a href="http://octodex.github.com/">The Octodex</a></dd>
      </dl>

      <hr class="footer-divider">


    <p class="right">&copy; 2013 <span title="0.11879s from fe2.rs.github.com">GitHub</span>, Inc. All rights reserved.</p>
    <a class="left" href="https://github.com/">
      <span class="mega-octicon octicon-mark-github"></span>
    </a>
    <ul id="legal">
        <li><a href="https://github.com/site/terms">Terms of Service</a></li>
        <li><a href="https://github.com/site/privacy">Privacy</a></li>
        <li><a href="https://github.com/security">Security</a></li>
    </ul>

  </div><!-- /.container -->

</div><!-- /.#footer -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
          <div class="suggester-container">
              <div class="suggester fullscreen-suggester js-navigation-container" id="fullscreen_suggester"
                 data-url="/tysonmatanich/viewportSize/suggestions/commit">
              </div>
          </div>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped leftwards" title="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped leftwards"
      title="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      Something went wrong with that request. Please try again.
      <a href="#" class="octicon octicon-remove-close ajax-error-dismiss"></a>
    </div>

    
    
    <span id='server_response_time' data-time='0.11954' data-host='fe2'></span>
    
  </body>
</html>

