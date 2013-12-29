
function selectModuleLink(link) {
    jQuery("#moduleList").find(".ui-state-active").removeClass("ui-state-active");
    if (link) {
        jQuery(link).addClass("ui-state-active");
    }
}

function selectUseCaseLink(link) {
    jQuery("#useCaseList").find(".ui-state-active").removeClass("ui-state-active");
    if (link) {
        jQuery(link).addClass("ui-state-active");
    }
}
