<!DOCTYPE html>
<!-- saved from url=(0072)https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>DevSync </title>
    <link rel="icon" href="https://pixelwibes.com/template/my-task/html/dist/favicon.ico" type="image/x-icon">
    <!-- Favicon-->
    <!-- plugin css file  -->
    <link rel="stylesheet" href="./admin/__ My-Task__ Dashboard_files/responsive.dataTables.min.css">
    <link rel="stylesheet" href="./admin/__ My-Task__ Dashboard_files/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="./admin/icofont/icofont.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="./admin/__ My-Task__ Dashboard_files/my-task.style.min.css">
    <style type="text/css" id="operaUserStyle"></style>
    <style id="apexcharts-css">
        @keyframes opaque {
            0% {
                opacity: 0
            }

            to {
                opacity: 1
            }
        }

        @keyframes resizeanim {

            0%,
            to {
                opacity: 0
            }
        }

        .apexcharts-canvas {
            position: relative;
            user-select: none
        }

        .apexcharts-canvas ::-webkit-scrollbar {
            -webkit-appearance: none;
            width: 6px
        }

        .apexcharts-canvas ::-webkit-scrollbar-thumb {
            border-radius: 4px;
            background-color: rgba(0, 0, 0, .5);
            box-shadow: 0 0 1px rgba(255, 255, 255, .5);
            -webkit-box-shadow: 0 0 1px rgba(255, 255, 255, .5)
        }

        .apexcharts-inner {
            position: relative
        }

        .apexcharts-text tspan {
            font-family: inherit
        }

        rect.legend-mouseover-inactive,
        .legend-mouseover-inactive rect,
        .legend-mouseover-inactive path,
        .legend-mouseover-inactive circle,
        .legend-mouseover-inactive line,
        .legend-mouseover-inactive text.apexcharts-yaxis-title-text,
        .legend-mouseover-inactive text.apexcharts-yaxis-label {
            transition: .15s ease all;
            opacity: .2
        }

        .apexcharts-legend-text {
            padding-left: 15px;
            margin-left: -15px;
        }

        .apexcharts-series-collapsed {
            opacity: 0
        }

        .apexcharts-tooltip {
            border-radius: 5px;
            box-shadow: 2px 2px 6px -4px #999;
            cursor: default;
            font-size: 14px;
            left: 62px;
            opacity: 0;
            pointer-events: none;
            position: absolute;
            top: 20px;
            display: flex;
            flex-direction: column;
            overflow: hidden;
            white-space: nowrap;
            z-index: 12;
            transition: .15s ease all
        }

        .apexcharts-tooltip.apexcharts-active {
            opacity: 1;
            transition: .15s ease all
        }

        .apexcharts-tooltip.apexcharts-theme-light {
            border: 1px solid #e3e3e3;
            background: rgba(255, 255, 255, .96)
        }

        .apexcharts-tooltip.apexcharts-theme-dark {
            color: #fff;
            background: rgba(30, 30, 30, .8)
        }

        .apexcharts-tooltip * {
            font-family: inherit
        }

        .apexcharts-tooltip-title {
            padding: 6px;
            font-size: 15px;
            margin-bottom: 4px
        }

        .apexcharts-tooltip.apexcharts-theme-light .apexcharts-tooltip-title {
            background: #eceff1;
            border-bottom: 1px solid #ddd
        }

        .apexcharts-tooltip.apexcharts-theme-dark .apexcharts-tooltip-title {
            background: rgba(0, 0, 0, .7);
            border-bottom: 1px solid #333
        }

        .apexcharts-tooltip-text-goals-value,
        .apexcharts-tooltip-text-y-value,
        .apexcharts-tooltip-text-z-value {
            display: inline-block;
            margin-left: 5px;
            font-weight: 600
        }

        .apexcharts-tooltip-text-goals-label:empty,
        .apexcharts-tooltip-text-goals-value:empty,
        .apexcharts-tooltip-text-y-label:empty,
        .apexcharts-tooltip-text-y-value:empty,
        .apexcharts-tooltip-text-z-value:empty,
        .apexcharts-tooltip-title:empty {
            display: none
        }

        .apexcharts-tooltip-text-goals-label,
        .apexcharts-tooltip-text-goals-value {
            padding: 6px 0 5px
        }

        .apexcharts-tooltip-goals-group,
        .apexcharts-tooltip-text-goals-label,
        .apexcharts-tooltip-text-goals-value {
            display: flex
        }

        .apexcharts-tooltip-text-goals-label:not(:empty),
        .apexcharts-tooltip-text-goals-value:not(:empty) {
            margin-top: -6px
        }

        .apexcharts-tooltip-marker {
            width: 12px;
            height: 12px;
            position: relative;
            top: 0;
            margin-right: 10px;
            border-radius: 50%
        }

        .apexcharts-tooltip-series-group {
            padding: 0 10px;
            display: none;
            text-align: left;
            justify-content: left;
            align-items: center
        }

        .apexcharts-tooltip-series-group.apexcharts-active .apexcharts-tooltip-marker {
            opacity: 1
        }

        .apexcharts-tooltip-series-group.apexcharts-active,
        .apexcharts-tooltip-series-group:last-child {
            padding-bottom: 4px
        }

        .apexcharts-tooltip-series-group-hidden {
            opacity: 0;
            height: 0;
            line-height: 0;
            padding: 0 !important
        }

        .apexcharts-tooltip-y-group {
            padding: 6px 0 5px
        }

        .apexcharts-custom-tooltip,
        .apexcharts-tooltip-box {
            padding: 4px 8px
        }

        .apexcharts-tooltip-boxPlot {
            display: flex;
            flex-direction: column-reverse
        }

        .apexcharts-tooltip-box > div {
            margin: 4px 0
        }

        .apexcharts-tooltip-box span.value {
            font-weight: 700
        }

        .apexcharts-tooltip-rangebar {
            padding: 5px 8px
        }

        .apexcharts-tooltip-rangebar .category {
            font-weight: 600;
            color: #777
        }

        .apexcharts-tooltip-rangebar .series-name {
            font-weight: 700;
            display: block;
            margin-bottom: 5px
        }

        .apexcharts-xaxistooltip,
        .apexcharts-yaxistooltip {
            opacity: 0;
            pointer-events: none;
            color: #373d3f;
            font-size: 13px;
            text-align: center;
            border-radius: 2px;
            position: absolute;
            z-index: 10;
            background: #eceff1;
            border: 1px solid #90a4ae
        }

        .apexcharts-xaxistooltip {
            padding: 9px 10px;
            transition: .15s ease all
        }

        .apexcharts-xaxistooltip.apexcharts-theme-dark {
            background: rgba(0, 0, 0, .7);
            border: 1px solid rgba(0, 0, 0, .5);
            color: #fff
        }

        .apexcharts-xaxistooltip:after,
        .apexcharts-xaxistooltip:before {
            left: 50%;
            border: solid transparent;
            content: " ";
            height: 0;
            width: 0;
            position: absolute;
            pointer-events: none
        }

        .apexcharts-xaxistooltip:after {
            border-color: transparent;
            border-width: 6px;
            margin-left: -6px
        }

        .apexcharts-xaxistooltip:before {
            border-color: transparent;
            border-width: 7px;
            margin-left: -7px
        }

        .apexcharts-xaxistooltip-bottom:after,
        .apexcharts-xaxistooltip-bottom:before {
            bottom: 100%
        }

        .apexcharts-xaxistooltip-top:after,
        .apexcharts-xaxistooltip-top:before {
            top: 100%
        }

        .apexcharts-xaxistooltip-bottom:after {
            border-bottom-color: #eceff1
        }

        .apexcharts-xaxistooltip-bottom:before {
            border-bottom-color: #90a4ae
        }

        .apexcharts-xaxistooltip-bottom.apexcharts-theme-dark:after,
        .apexcharts-xaxistooltip-bottom.apexcharts-theme-dark:before {
            border-bottom-color: rgba(0, 0, 0, .5)
        }

        .apexcharts-xaxistooltip-top:after {
            border-top-color: #eceff1
        }

        .apexcharts-xaxistooltip-top:before {
            border-top-color: #90a4ae
        }

        .apexcharts-xaxistooltip-top.apexcharts-theme-dark:after,
        .apexcharts-xaxistooltip-top.apexcharts-theme-dark:before {
            border-top-color: rgba(0, 0, 0, .5)
        }

        .apexcharts-xaxistooltip.apexcharts-active {
            opacity: 1;
            transition: .15s ease all
        }

        .apexcharts-yaxistooltip {
            padding: 4px 10px
        }

        .apexcharts-yaxistooltip.apexcharts-theme-dark {
            background: rgba(0, 0, 0, .7);
            border: 1px solid rgba(0, 0, 0, .5);
            color: #fff
        }

        .apexcharts-yaxistooltip:after,
        .apexcharts-yaxistooltip:before {
            top: 50%;
            border: solid transparent;
            content: " ";
            height: 0;
            width: 0;
            position: absolute;
            pointer-events: none
        }

        .apexcharts-yaxistooltip:after {
            border-color: transparent;
            border-width: 6px;
            margin-top: -6px
        }

        .apexcharts-yaxistooltip:before {
            border-color: transparent;
            border-width: 7px;
            margin-top: -7px
        }

        .apexcharts-yaxistooltip-left:after,
        .apexcharts-yaxistooltip-left:before {
            left: 100%
        }

        .apexcharts-yaxistooltip-right:after,
        .apexcharts-yaxistooltip-right:before {
            right: 100%
        }

        .apexcharts-yaxistooltip-left:after {
            border-left-color: #eceff1
        }

        .apexcharts-yaxistooltip-left:before {
            border-left-color: #90a4ae
        }

        .apexcharts-yaxistooltip-left.apexcharts-theme-dark:after,
        .apexcharts-yaxistooltip-left.apexcharts-theme-dark:before {
            border-left-color: rgba(0, 0, 0, .5)
        }

        .apexcharts-yaxistooltip-right:after {
            border-right-color: #eceff1
        }

        .apexcharts-yaxistooltip-right:before {
            border-right-color: #90a4ae
        }

        .apexcharts-yaxistooltip-right.apexcharts-theme-dark:after,
        .apexcharts-yaxistooltip-right.apexcharts-theme-dark:before {
            border-right-color: rgba(0, 0, 0, .5)
        }

        .apexcharts-yaxistooltip.apexcharts-active {
            opacity: 1
        }

        .apexcharts-yaxistooltip-hidden {
            display: none
        }

        .apexcharts-xcrosshairs,
        .apexcharts-ycrosshairs {
            pointer-events: none;
            opacity: 0;
            transition: .15s ease all
        }

        .apexcharts-xcrosshairs.apexcharts-active,
        .apexcharts-ycrosshairs.apexcharts-active {
            opacity: 1;
            transition: .15s ease all
        }

        .apexcharts-ycrosshairs-hidden {
            opacity: 0
        }

        .apexcharts-selection-rect {
            cursor: move
        }

        .svg_select_boundingRect,
        .svg_select_points_rot {
            pointer-events: none;
            opacity: 0;
            visibility: hidden
        }

        .apexcharts-selection-rect + g .svg_select_boundingRect,
        .apexcharts-selection-rect + g .svg_select_points_rot {
            opacity: 0;
            visibility: hidden
        }

        .apexcharts-selection-rect + g .svg_select_points_l,
        .apexcharts-selection-rect + g .svg_select_points_r {
            cursor: ew-resize;
            opacity: 1;
            visibility: visible
        }

        .svg_select_points {
            fill: #efefef;
            stroke: #333;
            rx: 2
        }

        .apexcharts-svg.apexcharts-zoomable.hovering-zoom {
            cursor: crosshair
        }

        .apexcharts-svg.apexcharts-zoomable.hovering-pan {
            cursor: move
        }

        .apexcharts-menu-icon,
        .apexcharts-pan-icon,
        .apexcharts-reset-icon,
        .apexcharts-selection-icon,
        .apexcharts-toolbar-custom-icon,
        .apexcharts-zoom-icon,
        .apexcharts-zoomin-icon,
        .apexcharts-zoomout-icon {
            cursor: pointer;
            width: 20px;
            height: 20px;
            line-height: 24px;
            color: #6e8192;
            text-align: center
        }

        .apexcharts-menu-icon svg,
        .apexcharts-reset-icon svg,
        .apexcharts-zoom-icon svg,
        .apexcharts-zoomin-icon svg,
        .apexcharts-zoomout-icon svg {
            fill: #6e8192
        }

        .apexcharts-selection-icon svg {
            fill: #444;
            transform: scale(.76)
        }

        .apexcharts-theme-dark .apexcharts-menu-icon svg,
        .apexcharts-theme-dark .apexcharts-pan-icon svg,
        .apexcharts-theme-dark .apexcharts-reset-icon svg,
        .apexcharts-theme-dark .apexcharts-selection-icon svg,
        .apexcharts-theme-dark .apexcharts-toolbar-custom-icon svg,
        .apexcharts-theme-dark .apexcharts-zoom-icon svg,
        .apexcharts-theme-dark .apexcharts-zoomin-icon svg,
        .apexcharts-theme-dark .apexcharts-zoomout-icon svg {
            fill: #f3f4f5
        }

        .apexcharts-canvas .apexcharts-reset-zoom-icon.apexcharts-selected svg,
        .apexcharts-canvas .apexcharts-selection-icon.apexcharts-selected svg,
        .apexcharts-canvas .apexcharts-zoom-icon.apexcharts-selected svg {
            fill: #008ffb
        }

        .apexcharts-theme-light .apexcharts-menu-icon:hover svg,
        .apexcharts-theme-light .apexcharts-reset-icon:hover svg,
        .apexcharts-theme-light .apexcharts-selection-icon:not(.apexcharts-selected):hover svg,
        .apexcharts-theme-light .apexcharts-zoom-icon:not(.apexcharts-selected):hover svg,
        .apexcharts-theme-light .apexcharts-zoomin-icon:hover svg,
        .apexcharts-theme-light .apexcharts-zoomout-icon:hover svg {
            fill: #333
        }

        .apexcharts-menu-icon,
        .apexcharts-selection-icon {
            position: relative
        }

        .apexcharts-reset-icon {
            margin-left: 5px
        }

        .apexcharts-menu-icon,
        .apexcharts-reset-icon,
        .apexcharts-zoom-icon {
            transform: scale(.85)
        }

        .apexcharts-zoomin-icon,
        .apexcharts-zoomout-icon {
            transform: scale(.7)
        }

        .apexcharts-zoomout-icon {
            margin-right: 3px
        }

        .apexcharts-pan-icon {
            transform: scale(.62);
            position: relative;
            left: 1px;
            top: 0
        }

        .apexcharts-pan-icon svg {
            fill: #fff;
            stroke: #6e8192;
            stroke-width: 2
        }

        .apexcharts-pan-icon.apexcharts-selected svg {
            stroke: #008ffb
        }

        .apexcharts-pan-icon:not(.apexcharts-selected):hover svg {
            stroke: #333
        }

        .apexcharts-toolbar {
            position: absolute;
            z-index: 11;
            max-width: 176px;
            text-align: right;
            border-radius: 3px;
            padding: 0 6px 2px;
            display: flex;
            justify-content: space-between;
            align-items: center
        }

        .apexcharts-menu {
            background: #fff;
            position: absolute;
            top: 100%;
            border: 1px solid #ddd;
            border-radius: 3px;
            padding: 3px;
            right: 10px;
            opacity: 0;
            min-width: 110px;
            transition: .15s ease all;
            pointer-events: none
        }

        .apexcharts-menu.apexcharts-menu-open {
            opacity: 1;
            pointer-events: all;
            transition: .15s ease all
        }

        .apexcharts-menu-item {
            padding: 6px 7px;
            font-size: 12px;
            cursor: pointer
        }

        .apexcharts-theme-light .apexcharts-menu-item:hover {
            background: #eee
        }

        .apexcharts-theme-dark .apexcharts-menu {
            background: rgba(0, 0, 0, .7);
            color: #fff
        }

        @media screen and (min-width: 768px) {
            .apexcharts-canvas:hover .apexcharts-toolbar {
                opacity: 1
            }
        }

        .apexcharts-canvas .apexcharts-element-hidden,
        .apexcharts-datalabel.apexcharts-element-hidden,
        .apexcharts-hide .apexcharts-series-points {
            opacity: 0;
        }

        .apexcharts-hidden-element-shown {
            opacity: 1;
            transition: 0.25s ease all;
        }

        .apexcharts-datalabel,
        .apexcharts-datalabel-label,
        .apexcharts-datalabel-value,
        .apexcharts-datalabels,
        .apexcharts-pie-label {
            cursor: default;
            pointer-events: none
        }

        .apexcharts-pie-label-delay {
            opacity: 0;
            animation-name: opaque;
            animation-duration: .3s;
            animation-fill-mode: forwards;
            animation-timing-function: ease
        }

        .apexcharts-radialbar-label {
            cursor: pointer;
        }

        .apexcharts-annotation-rect,
        .apexcharts-area-series .apexcharts-area,
        .apexcharts-area-series .apexcharts-series-markers .apexcharts-marker.no-pointer-events,
        .apexcharts-gridline,
        .apexcharts-line,
        .apexcharts-line-series .apexcharts-series-markers .apexcharts-marker.no-pointer-events,
        .apexcharts-point-annotation-label,
        .apexcharts-radar-series path,
        .apexcharts-radar-series polygon,
        .apexcharts-toolbar svg,
        .apexcharts-tooltip .apexcharts-marker,
        .apexcharts-xaxis-annotation-label,
        .apexcharts-yaxis-annotation-label,
        .apexcharts-zoom-rect {
            pointer-events: none
        }

        .apexcharts-marker {
            transition: .15s ease all
        }

        .resize-triggers {
            animation: 1ms resizeanim;
            visibility: hidden;
            opacity: 0;
            height: 100%;
            width: 100%;
            overflow: hidden
        }

        .contract-trigger:before,
        .resize-triggers,
        .resize-triggers > div {
            content: " ";
            display: block;
            position: absolute;
            top: 0;
            left: 0
        }

        .resize-triggers > div {
            height: 100%;
            width: 100%;
            background: #eee;
            overflow: auto
        }

        .contract-trigger:before {
            overflow: hidden;
            width: 200%;
            height: 200%
        }

        .apexcharts-bar-goals-markers {
            pointer-events: none
        }

        .apexcharts-bar-shadows {
            pointer-events: none
        }

        .apexcharts-rangebar-goals-markers {
            pointer-events: none
        }
    </style>

    <script charset="utf-8" src="./admin/__ My-Task__ Dashboard_files/twk-chunk-bf24a88e.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Dashboard_files/twk-chunk-71978bb6.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Dashboard_files/twk-chunk-7c2f6ba4.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Dashboard_files/twk-chunk-48f3b594.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Dashboard_files/twk-chunk-4fe9d5dd.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Dashboard_files/twk-chunk-2d0b9454.js.téléchargé"></script>
    <script charset="utf-8" src="./admin/__ My-Task__ Dashboard_files/twk-chunk-24d8db78.js.téléchargé"></script>
    <style type="text/css">
        #dhu2c3gktvv1727946453527 {
            outline: none !important;
            visibility: visible !important;
            resize: none !important;
            box-shadow: none !important;
            overflow: visible !important;
            background: none !important;
            opacity: 1 !important;
            filter: alpha(opacity=100) !important;
            -ms-filter: progid:DXImageTransform.Microsoft.Alpha(Opacity 1
        }

        )
        !important
        ;
        -mz-opacity:

        1
        !important
        ;
        -khtml-opacity:

        1
        !important
        ;
        top:auto

        !important
        ;
        right:

        0
        px

        !important
        ;
        bottom:

        0
        px

        !important
        ;
        left:auto

        !important
        ;
        position:fixed

        !important
        ;
        border:

        0
        !important
        ;
        min-height:

        0
        px

        !important
        ;
        min-width:

        0
        px

        !important
        ;
        max-height:none

        !important
        ;
        max-width:none

        !important
        ;
        padding:

        0
        px

        !important
        ;
        margin:

        0
        px

        !important
        ;
        -moz-transition-property:none

        !important
        ;
        -webkit-transition-property:none

        !important
        ;
        -o-transition-property:none

        !important
        ;
        transition-property:none

        !important
        ;
        transform:none

        !important
        ;
        -webkit-transform:none

        !important
        ;
        -ms-transform:none

        !important
        ;
        width:auto

        !important
        ;
        height:auto

        !important
        ;
        display:none

        !important
        ;
        z-index:

        2000000000
        !important
        ;
        background-color:transparent

        !important
        ;
        cursor:none

        !important
        ;
        float:none

        !important
        ;
        border-radius:unset

        !important
        ;
        pointer-events:auto

        !important
        ;
        clip:auto

        !important
        ;
        color-scheme:light

        !important
        ;
        }
        #dhu2c3gktvv1727946453527.widget-hidden {
            display: none !important;
        }

        #dhu2c3gktvv1727946453527.widget-visible {
            display: block !important;
        }

        @media print {
            #dhu2c3gktvv1727946453527.widget-visible {
                display: none !important;
            }
        }
    </style>
    <script src="./admin/__ My-Task__ Dashboard_files/emojione.min.js.téléchargé" type="text/javascript" async=""
            defer=""></script>
    <script src="./admin/__ My-Task__ Dashboard_files/emojione.min.js.téléchargé" type="text/javascript" async=""
            defer=""></script>
    <style type="text/css"  >
        @keyframes tawkMaxOpen {
                               0% {
                                   opacity: 0;
                                   transform: translate(0, 30px);;
                               }
                               to {
                                   opacity: 1;
                                   transform: translate(0, 0px);
                               }
                           }

    @-moz-keyframes tawkMaxOpen {
        0% {
            opacity: 0;
            transform: translate(0, 30px);;
        }
        to {
            opacity: 1;
            transform: translate(0, 0px);
        }
    }

    @-webkit-keyframes tawkMaxOpen {
        0% {
            opacity: 0;
            transform: translate(0, 30px);;
        }
        to {
            opacity: 1;
            transform: translate(0, 0px);
        }
    }

    #el09afo822ig1727946453569.open {
        animation: tawkMaxOpen .25s ease !important;
    }

    @keyframes tawkMaxClose {
        from {
            opacity: 1;
            transform: translate(0, 0px);;
        }
        to {
            opacity: 0;
            transform: translate(0, 30px);;
        }
    }

    @-moz-keyframes tawkMaxClose {
        from {
            opacity: 1;
            transform: translate(0, 0px);;
        }
        to {
            opacity: 0;
            transform: translate(0, 30px);;
        }
    }

    @-webkit-keyframes tawkMaxClose {
        from {
            opacity: 1;
            transform: translate(0, 0px);;
        }
        to {
            opacity: 0;
            transform: translate(0, 30px);;
        }
    }

    #el09afo822ig1727946453569.closed {
        animation: tawkMaxClose .25s ease !important
    }</style>
</head>
<body data-mytask="theme-indigo">

<div id="mytask-layout">

    <!-- sidebar -->
    <div class="sidebar px-4 py-4 py-md-5 me-0">
        <div class="d-flex flex-column h-100">
            <a href="https://pixelwibes.com/template/my-task/html/dist/index.html" class="mb-0 brand-icon">
                <span class="logo-icon">
                    <svg width="35" height="35" fill="currentColor" class="bi bi-clipboard-check" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"></path>
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
                        <a class="m-link active" href="User?action=dashboard">
                            <span>Dashboard</span></a>

                    </li>
                    <li class="collapsed">
                        <a class="m-link" href="User?action=users">
                            <span>Users</span> </a>

                    </li>
                    <li class="collapsed">
                        <a class="m-link" href="taskHistory?action=approve">
                            <span>Approve Change</span> </a>

                    </li>

                </c:if>
                <li class="collapsed">
                    <a class="m-link" href="Task">
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
                            <a class="nav-link text-primary collapsed"
                               href="https://pixelwibes.com/template/my-task/html/dist/help.html" title="Get Help">
                                <i class="icofont-info-square fs-5"></i>
                            </a>
                            <div class="avatar-list avatar-list-stacked px-3">
                                <img class="avatar rounded-circle"
                                     src="./admin/__ My-Task__ Dashboard_files/avatar2.jpg" alt="">
                                <img class="avatar rounded-circle"
                                     src="./admin/__ My-Task__ Dashboard_files/avatar1.jpg" alt="">
                                <img class="avatar rounded-circle"
                                     src="./admin/__ My-Task__ Dashboard_files/avatar3.jpg" alt="">
                                <img class="avatar rounded-circle"
                                     src="./admin/__ My-Task__ Dashboard_files/avatar4.jpg" alt="">
                                <img class="avatar rounded-circle"
                                     src="./admin/__ My-Task__ Dashboard_files/avatar7.jpg" alt="">
                                <img class="avatar rounded-circle"
                                     src="./admin/__ My-Task__ Dashboard_files/avatar8.jpg" alt="">
                                <span class="avatar rounded-circle text-center pointer" data-bs-toggle="modal"
                                      data-bs-target="#addUser"><i class="icofont-ui-add"></i></span>
                            </div>
                        </div>
                        <div class="dropdown notifications">
                            <a class="nav-link dropdown-toggle pulse"
                               href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"
                               role="button" data-bs-toggle="dropdown">
                                <i class="icofont-alarm fs-5"></i>
                                <span class="pulse-ring"></span>
                            </a>
                        </div>
                        <div class="dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center">
                            <div class="u-info me-2">
                                <p class="mb-0 text-end line-height-sm "><span
                                        class="font-weight-bold">${user.firstname} ${user.lastname}</span></p>
                                <small>${user.manage} Profile</small>
                            </div>
                            <a class="nav-link dropdown-toggle pulse p-0"
                               href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"
                               role="button" data-bs-toggle="dropdown" data-bs-display="static">
                                <img class="avatar lg rounded-circle img-thumbnail"
                                     src="./admin/__ My-Task__ Dashboard_files/profile_av.png" alt="profile">
                            </a>
                        </div>
                        <div class="px-md-1">
                            <a href="User?action=logout" data-bs-toggle="offcanvas" aria-expanded="false"
                               title="template setting">
                                <svg class="svg-stroke" xmlns="http://www.w3.org/2000/svg" width="22" height="22"
                                     viewBox="0 0 24 24" stroke="currentColor" fill="none" stroke-linecap="round"
                                     stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                    <path d="M10.325 4.317c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35a1.724 1.724 0 0 0 -1.066 2.573c.94 1.543 -.826 3.31 -2.37 2.37a1.724 1.724 0 0 0 -2.572 1.065c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065z"></path>
                                    <path d="M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0"></path>
                                </svg>
                            </a>
                        </div>
                    </div>

                    <!-- menu toggler -->
                    <button class="navbar-toggler p-0 border-0 menu-toggle order-3" type="button"
                            data-bs-toggle="collapse" data-bs-target="#mainHeader">
                        <span class="fa fa-bars"></span>
                    </button>

                    <!-- main menu Search-->
                    <div class="order-0 col-lg-4 col-md-4 col-sm-12 col-12 mb-3 mb-md-0 ">
                        <div class="input-group flex-nowrap input-group-lg">
                            <button type="button" class="input-group-text" id="addon-wrapping"><i
                                    class="fa fa-search"></i></button>
                            <input type="search" class="form-control" placeholder="Search" aria-label="search"
                                   aria-describedby="addon-wrapping">
                            <button type="button" class="input-group-text add-member-top" id="addon-wrappingone"
                                    data-bs-toggle="modal" data-bs-target="#addUser"><i class="fa fa-plus"></i></button>
                        </div>
                    </div>

                </div>
            </nav>
        </div>

        <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row g-3 mb-3 row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-2 row-cols-xl-4 row-cols-xxl-4">
                    <div class="col">
                        <div class="card ">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div class="avatar lg  rounded-1 no-thumbnail bg-lightgreen color-defult"><i
                                            class="bi bi-clipboard-data fs-4"></i></div>
                                    <div class="flex-fill ms-4">
                                        <div class="">Total Task</div>
                                        <h5 class="mb-0 ">${totalTask}</h5>
                                    </div>
                                    <a href="https://pixelwibes.com/template/my-task/html/dist/task.html"
                                       title="renewal-date" class="btn btn-link text-decoration-none  rounded-1"><i
                                            class="icofont-hand-drawn-right fs-2 "></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card ">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div class="avatar lg  rounded-1 no-thumbnail bg-lightblue color-defult"><i
                                            class="bi bi-list-check fs-4"></i></div>
                                    <div class="flex-fill ms-4">
                                        <div class="">Completed Task</div>
                                        <h5 class="mb-0 ">${completedTask}</h5>
                                    </div>
                                    <a href="https://pixelwibes.com/template/my-task/html/dist/task.html"
                                       title="space-used" class="btn btn-link text-decoration-none  rounded-1"><i
                                            class="icofont-hand-drawn-right fs-2 "></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card ">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div class="avatar lg  rounded-1 no-thumbnail bg-lightyellow color-defult"><i
                                            class="bi bi-journal-check fs-4"></i></div>
                                    <div class="flex-fill ms-4">
                                        <div class="">Cancelled Task</div>
                                        <h5 class="mb-0 ">${canceledTask}</h5>
                                    </div>
                                    <a href="https://pixelwibes.com/template/my-task/html/dist/task.html"
                                       title="view-members" class="btn btn-link text-decoration-none  rounded-1"><i
                                            class="icofont-hand-drawn-right fs-2 "></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card ">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div class="avatar lg  rounded-1 no-thumbnail bg-lightgreen color-defult"><i
                                            class="bi bi-clipboard-data fs-4"></i></div>
                                    <div class="flex-fill ms-4">
                                        <div class="">Total Token Used</div>
                                        <h5 class="mb-0 ">${totalToken}</h5>
                                    </div>
                                    <a href="https://pixelwibes.com/template/my-task/html/dist/task.html"
                                       title="renewal-date" class="btn btn-link text-decoration-none  rounded-1"><i
                                            class="icofont-hand-drawn-right fs-2 "></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row g-3 mb-3 row-deck">
                    <div class="col-md-12">
                        <div class="card mb-3">
                            <div class="card-header py-3 d-flex justify-content-between align-items-center">
                                <div class="info-header">
                                    <h6 class="mb-0 fw-bold ">Last 6 Task Created</h6>
                                </div>
                            </div>
                            <div class="card-body">
                                <div id="myProjectTable_wrapper" class="dataTables_wrapper dt-bootstrap5 no-footer">
                                    <div class="row">

                                        <div class="row">
                                            <div class="col-sm-12">
                                                <table id="myProjectTable"
                                                       class="table table-hover align-middle mb-0 nowrap dataTable no-footer dtr-inline"
                                                       style="width: 100%;" role="grid"
                                                       aria-describedby="myProjectTable_info">
                                                    <thead>
                                                    <tr role="row">
                                                        <th class="sorting_asc" tabindex="0"
                                                            aria-controls="myProjectTable" rowspan="1" colspan="1"
                                                            style="width: 190.2px;" aria-sort="ascending"
                                                            aria-label="Title: activate to sort column descending">Title
                                                        </th>
                                                        <th class="sorting" tabindex="0" aria-controls="myProjectTable"
                                                            rowspan="1" colspan="1" style="width: 141.2px;"
                                                            aria-label="Date Start: activate to sort column ascending">
                                                            Date Start
                                                        </th>
                                                        <th class="sorting" tabindex="0" aria-controls="myProjectTable"
                                                            rowspan="1" colspan="1" style="width: 123.2px;"
                                                            aria-label="Deadline: activate to sort column ascending">
                                                            Deadline
                                                        </th>
                                                        <th class="dt-body-right sorting" tabindex="0"
                                                            aria-controls="myProjectTable" rowspan="1" colspan="1"
                                                            style="width: 147.2px;"
                                                            aria-label="Leader: activate to sort column ascending">
                                                            Assigned To
                                                        </th>

                                                        <th class="dt-body-right sorting" tabindex="0"
                                                            aria-controls="myProjectTable" rowspan="1" colspan="1"
                                                            style="width: 93.2px;"
                                                            aria-label="Stage: activate to sort column ascending">Status
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="task" items="${listTask}" begin="0" end="5">
                                                        <tr role="row" class="odd">
                                                            <td tabindex="0" class="sorting_1"><a
                                                                    href="#">
                                                                ${task.title}</a></td>
                                                            <td>${task.creationDate}</td>
                                                            <td>${task.endDate}</td>
                                                            <td class=" dt-body-right"><img
                                                                    src="./admin/__ My-Task__ Dashboard_files/avatar4.jpg"
                                                                    alt="Avatar"
                                                                    class="avatar sm rounded-circle me-2"><a
                                                                    href="#">${task.assigneeTo.username}</a>
                                                            </td>
                                                            <td class=" dt-body-right">
                                                                <c:if test="${task.isCompleted=='COMPLETED'}">
                                                                    <span class="badge bg-success">${task.isCompleted}</span>
                                                                </c:if>
                                                                <c:if test="${task.isCompleted=='EN_PROGRESS'}">
                                                                    <span class="badge bg-warning">${task.isCompleted}</span>
                                                                </c:if>
                                                                <c:if test="${task.isCompleted=='CANCELLED'}">
                                                                    <span class="badge bg-danger">${task.isCompleted}</span>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="row">

                                        </div>
                                    </div>
                                </div>
                            </div><!-- Row End -->
                        </div>
                    </div>

                    <!-- Modal Members-->
                    <div class="modal fade" id="addUser" tabindex="-1" aria-labelledby="addUserLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title  fw-bold" id="addUserLabel">Employee Invitation</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="inviteby_email">
                                        <div class="input-group mb-3">
                                            <input type="email" class="form-control" placeholder="Email address"
                                                   id="exampleInputEmail1" aria-describedby="exampleInputEmail1">
                                            <button class="btn btn-dark" type="button" id="button-addon2">Sent</button>
                                        </div>
                                    </div>
                                    <div class="members_list">
                                        <h6 class="fw-bold ">Employee </h6>
                                        <ul class="list-unstyled list-group list-group-custom list-group-flush mb-0">
                                            <li class="list-group-item py-3 text-center text-md-start">
                                                <div class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
                                                    <div class="no-thumbnail mb-2 mb-md-0">
                                                        <img class="avatar lg rounded-circle"
                                                             src="./admin/__ My-Task__ Dashboard_files/avatar2.jpg"
                                                             alt="">
                                                    </div>
                                                    <div class="flex-fill ms-3 text-truncate">
                                                        <h6 class="mb-0  fw-bold">Rachel Carr(you)</h6>
                                                        <span class="text-muted">rachel.carr@gmail.com</span>
                                                    </div>
                                                    <div class="members-action">
                                                        <span class="members-role ">Admin</span>
                                                        <div class="btn-group">
                                                            <button type="button"
                                                                    class="btn bg-transparent dropdown-toggle"
                                                                    data-bs-toggle="dropdown" aria-expanded="false">
                                                                <i class="icofont-ui-settings  fs-6"></i>
                                                            </button>
                                                            <ul class="dropdown-menu dropdown-menu-end">
                                                                <li><a class="dropdown-item"
                                                                       href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"><i
                                                                        class="icofont-ui-password fs-6 me-2"></i>ResetPassword</a>
                                                                </li>
                                                                <li><a class="dropdown-item"
                                                                       href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"><i
                                                                        class="icofont-chart-line fs-6 me-2"></i>ActivityReport</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="list-group-item py-3 text-center text-md-start">
                                                <div class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
                                                    <div class="no-thumbnail mb-2 mb-md-0">
                                                        <img class="avatar lg rounded-circle"
                                                             src="./admin/__ My-Task__ Dashboard_files/avatar3.jpg"
                                                             alt="">
                                                    </div>
                                                    <div class="flex-fill ms-3 text-truncate">
                                                        <h6 class="mb-0  fw-bold">Lucas Baker<a
                                                                href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"
                                                                class="link-secondary ms-2">(Resend invitation)</a></h6>
                                                        <span class="text-muted">lucas.baker@gmail.com</span>
                                                    </div>
                                                    <div class="members-action">
                                                        <div class="btn-group">
                                                            <button type="button"
                                                                    class="btn bg-transparent dropdown-toggle"
                                                                    data-bs-toggle="dropdown" aria-expanded="false">
                                                                Members
                                                            </button>
                                                            <ul class="dropdown-menu dropdown-menu-end">
                                                                <li>
                                                                    <a class="dropdown-item"
                                                                       href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#">
                                                                        <i class="icofont-check-circled"></i>

                                                                        <span>All operations permission</span>
                                                                    </a>

                                                                </li>
                                                                <li>
                                                                    <a class="dropdown-item"
                                                                       href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#">
                                                                        <i class="fs-6 p-2 me-1"></i>
                                                                        <span>Only Invite &amp; manage team</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="btn-group">
                                                            <button type="button"
                                                                    class="btn bg-transparent dropdown-toggle"
                                                                    data-bs-toggle="dropdown" aria-expanded="false">
                                                                <i class="icofont-ui-settings  fs-6"></i>
                                                            </button>
                                                            <ul class="dropdown-menu dropdown-menu-end">
                                                                <li><a class="dropdown-item"
                                                                       href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"><i
                                                                        class="icofont-delete-alt fs-6 me-2"></i>Delete
                                                                    Member</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="list-group-item py-3 text-center text-md-start">
                                                <div class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
                                                    <div class="no-thumbnail mb-2 mb-md-0">
                                                        <img class="avatar lg rounded-circle"
                                                             src="./admin/__ My-Task__ Dashboard_files/avatar8.jpg"
                                                             alt="">
                                                    </div>
                                                    <div class="flex-fill ms-3 text-truncate">
                                                        <h6 class="mb-0  fw-bold">Una Coleman</h6>
                                                        <span class="text-muted">una.coleman@gmail.com</span>
                                                    </div>
                                                    <div class="members-action">
                                                        <div class="btn-group">
                                                            <button type="button"
                                                                    class="btn bg-transparent dropdown-toggle"
                                                                    data-bs-toggle="dropdown" aria-expanded="false">
                                                                Members
                                                            </button>
                                                            <ul class="dropdown-menu dropdown-menu-end">
                                                                <li>
                                                                    <a class="dropdown-item"
                                                                       href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#">
                                                                        <i class="icofont-check-circled"></i>

                                                                        <span>All operations permission</span>
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a class="dropdown-item"
                                                                       href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#">
                                                                        <i class="fs-6 p-2 me-1"></i>
                                                                        <span>Only Invite &amp; manage team</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="btn-group">
                                                            <div class="btn-group">
                                                                <button type="button"
                                                                        class="btn bg-transparent dropdown-toggle"
                                                                        data-bs-toggle="dropdown" aria-expanded="false">
                                                                    <i class="icofont-ui-settings  fs-6"></i>
                                                                </button>
                                                                <ul class="dropdown-menu dropdown-menu-end">
                                                                    <li><a class="dropdown-item"
                                                                           href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"><i
                                                                            class="icofont-ui-password fs-6 me-2"></i>ResetPassword</a>
                                                                    </li>
                                                                    <li><a class="dropdown-item"
                                                                           href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"><i
                                                                            class="icofont-chart-line fs-6 me-2"></i>ActivityReport</a>
                                                                    </li>
                                                                    <li><a class="dropdown-item"
                                                                           href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"><i
                                                                            class="icofont-delete-alt fs-6 me-2"></i>Suspend
                                                                        member</a></li>
                                                                    <li><a class="dropdown-item"
                                                                           href="https://pixelwibes.com/template/my-task/html/dist/project-dashboard.html#"><i
                                                                            class="icofont-not-allowed fs-6 me-2"></i>Delete
                                                                        Member</a></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- start: template setting, and more. -->
                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvas_setting"
                     aria-labelledby="offcanvas_setting">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title">Template Setting</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body d-flex flex-column">
                        <div class="mb-4">
                            <h6>Set Theme Color</h6>
                            <ul class="choose-skin list-unstyled mb-0">
                                <li data-theme="ValenciaRed">
                                    <div style="--mytask-theme-color: #D63B38;"></div>
                                </li>
                                <li data-theme="SunOrange">
                                    <div style="--mytask-theme-color: #F7A614;"></div>
                                </li>
                                <li data-theme="AppleGreen">
                                    <div style="--mytask-theme-color: #5BC43A;"></div>
                                </li>
                                <li data-theme="CeruleanBlue">
                                    <div style="--mytask-theme-color: #00B8D6;"></div>
                                </li>
                                <li data-theme="Mariner">
                                    <div style="--mytask-theme-color: #0066FE;"></div>
                                </li>
                                <li data-theme="PurpleHeart" class="active">
                                    <div style="--mytask-theme-color: #6238B3;"></div>
                                </li>
                                <li data-theme="FrenchRose">
                                    <div style="--mytask-theme-color: #EB5393;"></div>
                                </li>
                            </ul>
                        </div>
                        <div class="mb-4 flex-grow-1">
                            <h6>Set Theme Light/Dark/RTL</h6>
                            <!-- Theme: Switch Theme -->
                            <ul class="list-unstyled mb-0">
                                <li>
                                    <div class="form-check form-switch theme-switch">
                                        <input class="form-check-input fs-6" type="checkbox" role="switch"
                                               id="theme-switch">
                                        <label class="form-check-label mx-2" for="theme-switch">Enable Dark
                                            Mode!</label>
                                    </div>
                                </li>
                                <li>
                                    <div class="form-check form-switch theme-rtl">
                                        <input class="form-check-input fs-6" type="checkbox" role="switch"
                                               id="theme-rtl">
                                        <label class="form-check-label mx-2" for="theme-rtl">Enable RTL Mode!</label>
                                    </div>
                                </li>
                                <li>
                                    <div class="form-check form-switch monochrome-toggle">
                                        <input class="form-check-input fs-6" type="checkbox" role="switch"
                                               id="monochrome">
                                        <label class="form-check-label mx-2" for="monochrome">Monochrome Mode</label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="d-flex">
                            <a href="https://themeforest.net/item/mytask-hr-project-management-admin-template/31974551"
                               class="btn w-100 me-1 py-2 btn-primary">Buy Now</a>
                            <a href="https://themeforest.net/user/pixelwibes/portfolio"
                               class="btn w-100 ms-1 py-2 btn-dark">View Portfolio</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Jquery Core Js -->
            <script src="./admin/__ My-Task__ Dashboard_files/twk-main.js.téléchargé" charset="UTF-8"
                    crossorigin="*"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/twk-vendor.js.téléchargé" charset="UTF-8"
                    crossorigin="*"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/twk-chunk-vendors.js.téléchargé" charset="UTF-8"
                    crossorigin="*"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/twk-chunk-common.js.téléchargé" charset="UTF-8"
                    crossorigin="*"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/twk-runtime.js.téléchargé" charset="UTF-8"
                    crossorigin="*"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/twk-app.js.téléchargé" charset="UTF-8"
                    crossorigin="*"></script>
            <script async="" src="./admin/__ My-Task__ Dashboard_files/1f3d4os21" charset="UTF-8"
                    crossorigin="*"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/libscripts.bundle.js.téléchargé"></script>

            <!-- Plugin Js-->
            <script src="./admin/__ My-Task__ Dashboard_files/apexcharts.bundle.js.téléchargé"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/dataTables.bundle.js.téléchargé"></script>

            <!-- Jquery Page Js -->
            <script src="./admin/__ My-Task__ Dashboard_files/template.js.téléchargé"></script>
            <script src="./admin/__ My-Task__ Dashboard_files/index.js.téléchargé"></script>


            <svg id="SvgjsSvg1001" width="2" height="0" xmlns="http://www.w3.org/2000/svg" version="1.1"
                 xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.dev"
                 style="overflow: hidden; top: -100%; left: -100%; position: absolute; opacity: 0;">
                <defs id="SvgjsDefs1002"></defs>
                <polyline id="SvgjsPolyline1003" points="0,0"></polyline>
                <path id="SvgjsPath1004" d="M0 0 "></path>
            </svg>
            <script async="" charset="UTF-8" src="./admin/__ My-Task__ Dashboard_files/en.js.téléchargé"></script>
            <div id="dhu2c3gktvv1727946453527" class="widget-visible">
                <iframe src="./admin/__ My-Task__ Dashboard_files/saved_resource.html" frameborder="0" scrolling="no"
                        width="64px" height="60px"
                        style="outline:none !important; visibility:visible !important; resize:none !important; box-shadow:none !important; overflow:visible !important; background:none !important; opacity:1 !important; filter:alpha(opacity=100) !important; -ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity 1}) !important; -mz-opacity:1 !important; -khtml-opacity:1 !important; top:auto !important; right:20px !important; bottom:20px !important; left:auto !important; position:fixed !important; border:0 !important; min-height:60px !important; min-width:64px !important; max-height:60px !important; max-width:64px !important; padding:0 !important; margin:0 !important; -moz-transition-property:none !important; -webkit-transition-property:none !important; -o-transition-property:none !important; transition-property:none !important; transform:none !important; -webkit-transform:none !important; -ms-transform:none !important; width:64px !important; height:60px !important; display:block !important; z-index:1000001 !important; background-color:transparent !important; cursor:none !important; float:none !important; border-radius:unset !important; pointer-events:auto !important; clip:auto !important; color-scheme:light !important;"
                        id="dtrat4tva2do1727946453543" class="" title="chat widget"></iframe>
                <iframe src="./admin/__ My-Task__ Dashboard_files/saved_resource(1).html" frameborder="0" scrolling="no"
                        width="350px" height="520px"
                        style="outline:none !important; visibility:visible !important; resize:none !important; box-shadow:none !important; overflow:visible !important; background:none !important; opacity:1 !important; filter:alpha(opacity=100) !important; -ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity 1}) !important; -mz-opacity:1 !important; -khtml-opacity:1 !important; top:auto !important; right:10px !important; bottom:90px !important; left:auto !important; position:fixed !important; border:0 !important; min-height:520px !important; min-width:350px !important; max-height:520px !important; max-width:350px !important; padding:0 !important; margin:0 !important; -moz-transition-property:none !important; -webkit-transition-property:none !important; -o-transition-property:none !important; transition-property:none !important; transform:none !important; -webkit-transform:none !important; -ms-transform:none !important; width:350px !important; height:520px !important; display:none !important; z-index:1000002 !important; background-color:transparent !important; cursor:none !important; float:none !important; border-radius:5px !important; pointer-events:auto !important; clip:auto !important; color-scheme:light !important;"
                        id="el09afo822ig1727946453569" class="" title="chat widget"></iframe>
                <iframe src="./admin/__ My-Task__ Dashboard_files/saved_resource(2).html" frameborder="0" scrolling="no"
                        width="360px" height="145px"
                        style="outline:none !important; visibility:visible !important; resize:none !important; box-shadow:none !important; overflow:visible !important; background:none !important; opacity:1 !important; filter:alpha(opacity=100) !important; -ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity 1}) !important; -mz-opacity:1 !important; -khtml-opacity:1 !important; top:auto !important; right:20px !important; bottom:100px; left:auto !important; position:fixed !important; border:0 !important; min-height:145px !important; min-width:360px !important; max-height:145px !important; max-width:360px !important; padding:0 !important; margin:0 !important; -moz-transition-property:none !important; -webkit-transition-property:none !important; -o-transition-property:none !important; transition-property:none !important; transform:none !important; -webkit-transform:none !important; -ms-transform:none !important; width:360px !important; height:145px !important; display:none !important; z-index:auto !important; background-color:transparent !important; cursor:none !important; float:none !important; border-radius:unset !important; pointer-events:auto !important; clip:auto !important; color-scheme:light !important;"
                        id="dqs5lh94ovcg1727946453551" class="" title="chat widget"></iframe>
                <div id="chat-bubble"></div>
            </div>
</body>
</html>