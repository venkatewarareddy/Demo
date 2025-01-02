(function (document, $) {
  "use strict";

  // when dialog gets injected
  $(document).on("foundation-contentloaded", function (e) {
    // if there is already an inital value make sure the according target element becomes visible
    checkboxShowHideHandler($(".cq-dialog-checkbox-showhide", e.target));
  });

  $(document).on("change", ".cq-dialog-checkbox-showhide", function (e) {
    checkboxShowHideHandler($(this));
  });

  function checkboxShowHideHandler(el) {
    el.each(function (i, element) {
      if ($(element).is("coral-checkbox")) {
        // handle Coral3 base drop-down
        Coral.commons.ready(element, function (component) {
          showHide(component, element);
          component.on("change", function () {
            showHide(component, element);
          });
        });
      } else {
        // handle Coral2 based drop-down
        var component = $(element).data("checkbox");
        if (component) {
          showHide(component, element);
        }
      }
    })
  }

  function showHide(component, element) {
    console.log('showing');
    // get the selector to find the target elements. its stored as data-.. attribute
    var target = $(element).data("cqDialogCheckboxShowhideTarget");
    var $target = $(target);


    if (target) {
      $target.addClass("hide");
      if (component.checked) {
        $target.removeClass("hide");
      }
    }
  }
})(document, Granite.$);


// (function (document, $) {
//   "use strict";

//   $(document).on("foundation-contentloaded", function (e) {
//     checkboxShowHideHandler($(".cq-dialog-checkbox-showhide", e.target));
//   });

//   $(document).on("change", ".cq-dialog-checkbox-showhide", function (e) {
//     checkboxShowHideHandler($(this));
//   });

//   function checkboxShowHideHandler(el) {
//     el.each(function (i, element) {
//       Coral.commons.ready(element, function (component) {
//         showHide(component, element);
//         component.on("change", function () {
//           showHide(component, element);
//         });
//       });
//     });
//   }

//   function showHide(component, element) {
//     var target = $(element).data("cqDialogCheckboxShowhideTarget");
//     var $target = $(target);

//     if (target) {
//       $target.addClass("hide");
//       if (component.checked) {
//         $target.removeClass("hide");
//       }
//     }
//   }

//   // Handle dialog submit
//   $(document).on("click", ".cq-dialog-submit", function (e) {
//     e.preventDefault();
//     var dialog = $(this).closest(".cq-dialog");

//     // Get values
//     var pagePath = dialog.find("#pagePath").val();  // Assuming you have this field in your dialog
//     var enablePii = dialog.find("#enablePii").prop("checked");  // Checkbox value
//     var cssClass = dialog.find("#cssClass").val();  // Text field value

//     console.log("Submitting dialog values:", {
//       pagePath: pagePath,
//       enablePii: enablePii,
//       cssClass: cssClass,
//     });

//     // AJAX call to servlet
//     $.ajax({
//       url: "/bin/saveSingleArticle",
//       type: "GET",
//       data: {
//         pagePath: pagePath,  // Send the page path along with other data
//         enablePii: enablePii,
//         cssClass: cssClass,
//       },
//       success: function () {
//         console.log("Properties saved successfully");
//         dialog[0].close(); // Close the dialog
//       },
//       error: function (xhr) {
//         console.error("Error: " + xhr.responseText);
//       },
//     });
//   });
// })(document, Granite.$);
