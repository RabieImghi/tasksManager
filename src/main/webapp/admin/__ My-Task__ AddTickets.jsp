<!DOCTYPE html>
<!-- saved from url=(0062)https://pixelwibes.com/template/my-task/html/dist/tickets.html -->
<html class="no-js" lang="en" dir="ltr">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>DevSync</title>
    <link rel="icon" href="https://pixelwibes.com/template/my-task/html/dist/favicon.ico" type="image/x-icon"> <!-- Favicon-->
    <!-- plugin css file  -->
    <link rel="stylesheet" href="./admin/__ My-Task__ Tickets_files/responsive.dataTables.min.css">
    <link rel="stylesheet" href="./admin/__ My-Task__ Tickets_files/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="./admin/icofont/icofont.min.css">
    <link rel="stylesheet" href="./admin/icofont/icofont.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="./admin/__ My-Task__ Tickets_files/my-task.style.min.css">
    <style type="text/css" id="operaUserStyle"></style>
    <script charset="utf-8" src="./admin/__ My-Task__ Tickets_files/twk-chunk-bf24a88e.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Tickets_files/twk-chunk-71978bb6.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Tickets_files/twk-chunk-7c2f6ba4.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Tickets_files/twk-chunk-48f3b594.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Tickets_files/twk-chunk-4fe9d5dd.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Tickets_files/twk-chunk-2d0b9454.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Tickets_files/twk-chunk-24d8db78.js.téléchargé"></script>
    <style type="text/css">
        #v5fvd7tj2j81727946316564 {
            outline:none !important;
            visibility:visible !important;
            resize:none !important;
            box-shadow:none !important;
            overflow:visible !important;
            background:none !important;
            opacity:1 !important;
            filter:alpha(opacity=100) !important;
            -ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity 1}) !important;
            -mz-opacity:1 !important;
            -khtml-opacity:1 !important;
            top:auto !important;
            right:0px !important;
            bottom:0px !important;
            left:auto !important;
            position:fixed !important;
            border:0 !important;
            min-height:0px  !important;
            min-width:0px  !important;
            max-height:none  !important;
            max-width:none  !important;
            padding:0px !important;
            margin:0px !important;
            -moz-transition-property:none !important;
            -webkit-transition-property:none !important;
            -o-transition-property:none !important;
            transition-property:none !important;
            transform:none !important;
            -webkit-transform:none !important;
            -ms-transform:none !important;
            width:auto !important;
            height:auto  !important;
            display:none !important;
            z-index:2000000000 !important;
            background-color:transparent !important;
            cursor:none !important;
            float:none !important;
            border-radius:unset !important;
            pointer-events:auto !important;
            clip:auto !important;
            color-scheme:light !important;
        }
        #v5fvd7tj2j81727946316564.widget-hidden {
            display: none !important;
        }
        #v5fvd7tj2j81727946316564.widget-visible {
            display: block !important;
        }
        @media print{
             #v5fvd7tj2j81727946316564.widget-visible {
                display: none !important;
             }
        }
    </style>
    <script src="./admin/__ My-Task__ Tickets_files/emojione.min.js.téléchargé" type="text/javascript" async="" defer=""></script><script src="./admin/__ My-Task__ Tickets_files/emojione.min.js.téléchargé" type="text/javascript" async="" defer=""></script><style type="text/css">@keyframes tawkMaxOpen{0%{opacity:0;transform:translate(0, 30px);;}to{opacity:1;transform:translate(0, 0px);}}@-moz-keyframes tawkMaxOpen{0%{opacity:0;transform:translate(0, 30px);;}to{opacity:1;transform:translate(0, 0px);}}@-webkit-keyframes tawkMaxOpen{0%{opacity:0;transform:translate(0, 30px);;}to{opacity:1;transform:translate(0, 0px);}}#zupmpvmhcq6g1727946316587.open{animation : tawkMaxOpen .25s ease!important;}@keyframes tawkMaxClose{from{opacity: 1;transform:translate(0, 0px);;}to{opacity: 0;transform:translate(0, 30px);;}}@-moz-keyframes tawkMaxClose{from{opacity: 1;transform:translate(0, 0px);;}to{opacity: 0;transform:translate(0, 30px);;}}@-webkit-keyframes tawkMaxClose{from{opacity: 1;transform:translate(0, 0px);;}to{opacity: 0;transform:translate(0, 30px);;}}#zupmpvmhcq6g1727946316587.closed{animation: tawkMaxClose .25s ease!important}</style></head>
<body data-mytask="theme-indigo" class="" style="">

<div id="mytask-layout">

    <!-- sidebar -->
    <div class="sidebar px-4 py-4 py-md-5 me-0">
        <div class="d-flex flex-column h-100">
            <a href="https://pixelwibes.com/template/my-task/html/dist/index.html" class="mb-0 brand-icon">
                <span class="logo-icon">
                    <svg width="35" height="35" fill="currentColor" class="bi bi-clipboard-check" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"></path>
                        <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"></path>
                        <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"></path>
                    </svg>
                </span>
                <span class="logo-text">My-Task</span>
            </a>
            <!-- Menu: main ul -->

            <ul class="menu-list flex-grow-1 mt-3">
                <c:if test="${user.manage=='MANAGER'}">
                    <li class="collapsed">
                        <a class="m-link "  href="User?action=dashboard">
                            <span>Dashboard</span></a>

                    </li>
                    <li class="collapsed">
                        <a class="m-link" href="User?action=users">
                            <span>Users</span> </a>

                    </li>
                    <li class="collapsed">
                        <a class="m-link" href="Tag">
                            <span>Tags</span> </a>

                    </li>
                    <li class="collapsed">
                        <a class="m-link" href="taskHistory?action=approve">
                            <span>Approve Change</span> </a>

                    </li>

                </c:if>
                <li class="collapsed">
                    <a class="m-link active"  href="Task">
                        <span>Tasks</span> </a>

                </li>
            </ul>
            
            
            <!-- Menu: menu collepce btn -->
            <button type="button" class="btn btn-link sidebar-mini-btn text-light">
                <span class="ms-2"><i class="icofont-bubble-right"></i></span>
            </button>
        </div>
    </div>

    <!-- main body area -->
    <div class="main px-lg-4 px-md-4"> 

        <!-- Body: Header -->
        <div class="header">
            <nav class="navbar py-4">
                <div class="container-xxl">
    
                    <!-- header rightbar icon -->
                    <div class="h-right d-flex align-items-center mr-5 mr-lg-0 order-1">
                        <div class="d-flex">
                            <a class="nav-link text-primary collapsed" href="https://pixelwibes.com/template/my-task/html/dist/help.html" title="Get Help">
                                <i class="icofont-info-square fs-5"></i>
                            </a>
                            <div class="avatar-list avatar-list-stacked px-3">
                                <img class="avatar rounded-circle" src="./admin/__ My-Task__ Tickets_files/avatar2.jpg" alt="">
                                <img class="avatar rounded-circle" src="./admin/__ My-Task__ Tickets_files/avatar1.jpg" alt="">
                                <img class="avatar rounded-circle" src="./admin/__ My-Task__ Tickets_files/avatar3.jpg" alt="">
                                <img class="avatar rounded-circle" src="./admin/__ My-Task__ Tickets_files/avatar4.jpg" alt="">
                                <img class="avatar rounded-circle" src="./admin/__ My-Task__ Tickets_files/avatar7.jpg" alt="">
                                <img class="avatar rounded-circle" src="./admin/__ My-Task__ Tickets_files/avatar8.jpg" alt="">
                                <span class="avatar rounded-circle text-center pointer" data-bs-toggle="modal" data-bs-target="#addUser"><i class="icofont-ui-add"></i></span>
                            </div>
                        </div>
                        <div class="dropdown notifications">
                            <a class="nav-link dropdown-toggle pulse" href="https://pixelwibes.com/template/my-task/html/dist/tickets.html#" role="button" data-bs-toggle="dropdown">
                                <i class="icofont-alarm fs-5"></i>
                                <span class="pulse-ring"></span>
                            </a>
                            <div id="NotificationsDiv" class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-sm-end p-0 m-0">
                                <div class="card border-0 w380">
                                    <div class="card-header border-0 p-3">
                                        <h5 class="mb-0 font-weight-light d-flex justify-content-between">
                                            <span>Notifications</span>
                                            <span class="badge text-white">11</span>
                                        </h5>
                                    </div>
                                    <a class="card-footer text-center border-top-0" href="https://pixelwibes.com/template/my-task/html/dist/tickets.html#"> View all notifications</a>
                                </div>
                            </div>
                        </div>
                        <div class="dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center">
                            <div class="u-info me-2">
                                <p class="mb-0 text-end line-height-sm "><span class="font-weight-bold">${user.firstname} ${user.lastname}</span></p>
                                <small>${user.manage} Profile</small>
                            </div>
                            <a class="nav-link dropdown-toggle pulse p-0" href="https://pixelwibes.com/template/my-task/html/dist/tickets.html#" role="button" data-bs-toggle="dropdown" data-bs-display="static">
                                <img class="avatar lg rounded-circle img-thumbnail" src="./admin/__ My-Task__ Tickets_files/profile_av.png" alt="profile">
                            </a>
                        </div>
                        <div class="px-md-1">
                            <a href="User?action=logout" data-bs-toggle="offcanvas" aria-expanded="false" title="template setting">
                                <svg class="svg-stroke" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 24 24" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                    <path d="M10.325 4.317c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35a1.724 1.724 0 0 0 -1.066 2.573c.94 1.543 -.826 3.31 -2.37 2.37a1.724 1.724 0 0 0 -2.572 1.065c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065z"></path>
                                    <path d="M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0"></path>
                                </svg>
                            </a>
                        </div>
                    </div>
    
                    <!-- menu toggler -->
                    <button class="navbar-toggler p-0 border-0 menu-toggle order-3" type="button" data-bs-toggle="collapse" data-bs-target="#mainHeader">
                        <span class="fa fa-bars"></span>
                    </button>
    
                    <!-- main menu Search-->
                    <div class="order-0 col-lg-4 col-md-4 col-sm-12 col-12 mb-3 mb-md-0 ">
                        <div class="input-group flex-nowrap input-group-lg">
                            <button type="button" class="input-group-text" id="addon-wrapping"><i class="fa fa-search"></i></button>
                            <input type="search" class="form-control" placeholder="Search" aria-label="search" aria-describedby="addon-wrapping">
                            <button type="button" class="input-group-text add-member-top" id="addon-wrappingone" data-bs-toggle="modal" data-bs-target="#addUser"><i class="fa fa-plus"></i></button>
                        </div>
                    </div>
    
                </div>
            </nav>
        </div>

        <!-- Body: Body -->
        <div class="body d-flex py-lg-3 py-md-2">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">Tickets</h3>
                            <p>
                                <c:if test="${not empty errorDate}">
                                    <span style="color:red;">${errorDate}</span>
                                </c:if>
                            </p>
                            <div class="col-auto d-flex w-sm-100">
                                <button type="button" class="btn btn-dark btn-set-task w-sm-100" data-bs-toggle="modal" data-bs-target="#tickadd"><i class="icofont-plus-circle me-2 fs-6"></i>Add Tickets</button>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="modal-content">
                    <form action="Task" method="post">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="sub" class="form-label">Title</label>
                                <input type="text" name="title" placeholder="Title ..." class="form-control" id="sub">
                            </div>
                            <div class="deadline-form">
                                    <div class="row g-3 mb-3">
                                        <div class="col">
                                            <label for="deptwo2" class="form-label">Creted Date</label>
                                            <input type="date" name="creationDate" class="form-control" id="deptwo2">
                                        </div>
                                        <div class="col">
                                            <label for="deptwo" class="form-label">End Date</label>
                                            <input type="date" name="endDate" class="form-control" id="deptwo">
                                        </div>
                                    </div>
                            </div>
                            <input type="hidden" value="${user.id}" name="user_id">
                            <c:if test="${user.manage=='MANAGER'}">
                            <div class="mb-3">
                                <label class="form-label">Assignee To To</label>
                                <select class="form-select" name="assigneeTo_id">
                                    <c:forEach var="users" items="${userList}">
                                        <option value="${users.id}">${users.username}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${user.manage=='USER'}">
                            <input type="hidden" name="assigneeTo_id" value="${user.id}" >
                            </c:if>
                            <div class="mb-3">
                                <label class="form-label">List Tags</label>
                                <select class=" form-control" name="tages[]" multiple data-coreui-search="true">
                                    <c:forEach var="tage" items="${tagesList}">
                                        <option value="${tage.id}">${tage.name}</option>
                                    </c:forEach>
                                </select>
                            <div class="col-md-12">
                                <label for="addnote" class="form-label">Description</label>
                                <textarea name="description" class="form-control" id="addnote" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer mt-3">
                            <button type="submit" name="actionType" value="addTask" class="btn btn-primary">Create Task</button>
                        </div>
                    </form>
                </div>




            </div>
        </div>
        

    </div>

</div>
<!-- Jquery Core Js -->
<script src="./admin/__ My-Task__ Tickets_files/twk-main.js.téléchargé" charset="UTF-8" crossorigin="*"></script><script src="./admin/__ My-Task__ Tickets_files/twk-vendor.js.téléchargé" charset="UTF-8" crossorigin="*"></script><script src="./admin/__ My-Task__ Tickets_files/twk-chunk-vendors.js.téléchargé" charset="UTF-8" crossorigin="*"></script><script src="./admin/__ My-Task__ Tickets_files/twk-chunk-common.js.téléchargé" charset="UTF-8" crossorigin="*"></script><script src="./admin/__ My-Task__ Tickets_files/twk-runtime.js.téléchargé" charset="UTF-8" crossorigin="*"></script><script src="./admin/__ My-Task__ Tickets_files/twk-app.js.téléchargé" charset="UTF-8" crossorigin="*"></script><script async="" src="./admin/__ My-Task__ Tickets_files/1f3d4os21" charset="UTF-8" crossorigin="*"></script><script src="./admin/__ My-Task__ Tickets_files/libscripts.bundle.js.téléchargé"></script>

<!-- Plugin Js-->
<script src="./admin/__ My-Task__ Tickets_files/dataTables.bundle.js.téléchargé"></script>

<!-- Jquery Page Js -->
<script src="./admin/__ My-Task__ Tickets_files/template.js.téléchargé"></script>
<script>
    // project data table
    $(document).ready(function() {
        $('#myProjectTable')
        .addClass( 'nowrap' )
        .dataTable( {
            responsive: true,
            columnDefs: [
                { targets: [-1, -3], className: 'dt-body-right' }
            ]
        });
        $('.deleterow').on('click',function(){
        var tablename = $(this).closest('table').DataTable();  
        tablename
                .row( $(this)
                .parents('tr') )
                .remove()
                .draw();

        } );
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@coreui/coreui@5.1.2/dist/js/coreui.min.js" integrity="sha384-kiD3MgQ2eSqSjSfkoKS7/ipCvMvkfmpWHk3WRppeqnYxCVF0wQ+7gHzkXfJyvHbQ" crossorigin="anonymous"></script>
<script async="" charset="UTF-8" src="./admin/__ My-Task__ Tickets_files/en.js.téléchargé"></script><div id="v5fvd7tj2j81727946316564" class="widget-visible"><iframe src="./admin/__ My-Task__ Tickets_files/saved_resource.html" frameborder="0" scrolling="no" width="64px" height="60px" style="outline:none !important; visibility:visible !important; resize:none !important; box-shadow:none !important; overflow:visible !important; background:none !important; opacity:1 !important; filter:alpha(opacity=100) !important; -ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity 1}) !important; -mz-opacity:1 !important; -khtml-opacity:1 !important; top:auto !important; right:20px !important; bottom:20px !important; left:auto !important; position:fixed !important; border:0 !important; min-height:60px !important; min-width:64px !important; max-height:60px !important; max-width:64px !important; padding:0 !important; margin:0 !important; -moz-transition-property:none !important; -webkit-transition-property:none !important; -o-transition-property:none !important; transition-property:none !important; transform:none !important; -webkit-transform:none !important; -ms-transform:none !important; width:64px !important; height:60px !important; display:block !important; z-index:1000001 !important; background-color:transparent !important; cursor:none !important; float:none !important; border-radius:unset !important; pointer-events:auto !important; clip:auto !important; color-scheme:light !important;" id="v7oi33kqereo1727946316569" class="" title="chat widget"></iframe><iframe src="./admin/__ My-Task__ Tickets_files/saved_resource(1).html" frameborder="0" scrolling="no" width="350px" height="520px" style="outline:none !important; visibility:visible !important; resize:none !important; box-shadow:none !important; overflow:visible !important; background:none !important; opacity:1 !important; filter:alpha(opacity=100) !important; -ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity 1}) !important; -mz-opacity:1 !important; -khtml-opacity:1 !important; top:auto !important; right:10px !important; bottom:90px !important; left:auto !important; position:fixed !important; border:0 !important; min-height:520px !important; min-width:350px !important; max-height:520px !important; max-width:350px !important; padding:0 !important; margin:0 !important; -moz-transition-property:none !important; -webkit-transition-property:none !important; -o-transition-property:none !important; transition-property:none !important; transform:none !important; -webkit-transform:none !important; -ms-transform:none !important; width:350px !important; height:520px !important; display:none !important; z-index:1000002 !important; background-color:transparent !important; cursor:none !important; float:none !important; border-radius:5px !important; pointer-events:auto !important; clip:auto !important; color-scheme:light !important;" id="zupmpvmhcq6g1727946316587" class="" title="chat widget"></iframe><iframe src="./admin/__ My-Task__ Tickets_files/saved_resource(2).html" frameborder="0" scrolling="no" width="360px" height="145px" style="outline:none !important; visibility:visible !important; resize:none !important; box-shadow:none !important; overflow:visible !important; background:none !important; opacity:1 !important; filter:alpha(opacity=100) !important; -ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity 1}) !important; -mz-opacity:1 !important; -khtml-opacity:1 !important; top:auto !important; right:20px !important; bottom:100px; left:auto !important; position:fixed !important; border:0 !important; min-height:145px !important; min-width:360px !important; max-height:145px !important; max-width:360px !important; padding:0 !important; margin:0 !important; -moz-transition-property:none !important; -webkit-transition-property:none !important; -o-transition-property:none !important; transition-property:none !important; transform:none !important; -webkit-transform:none !important; -ms-transform:none !important; width:360px !important; height:145px !important; display:none !important; z-index:auto !important; background-color:transparent !important; cursor:none !important; float:none !important; border-radius:unset !important; pointer-events:auto !important; clip:auto !important; color-scheme:light !important;" id="wnljrgp5uv1727946316577" class="" title="chat widget"></iframe><div id="chat-bubble"></div></div></body></html>