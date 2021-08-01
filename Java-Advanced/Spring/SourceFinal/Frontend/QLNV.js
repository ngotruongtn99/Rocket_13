var listAccount = [];
var listDepartment = [];
var listPosition = [];
var currentPage = 1;
var size = 5;
var totalPages;
var sortField = "id";
var isAsc = true;

$(function () {
  getListEmployees();
  getListDepartment();
  getListPosition();
  showAvatar();
  $("#form1").hide();
  $("#Create_Date_ID").attr("disabled", "disabled");
  $("#ID_ID").attr("disabled", "disabled");
  $("#reset_btn").click(function () {
    $("#ID_ID").val("");
    $("#Email_ID").val("");
    $("#Username_ID").val("");
    $("#Fullname_ID").val("");
    $("#Department_ID").val("");
    $("#Position_ID").val("");
    $("#Create_Date_ID").val("");
  });

  $("#Main_Form_ID").submit(function () {
    // var v_ID_ID = $("#ID_ID").val();
    var v_Email_ID = $("#Email_ID").val();
    var v_Username_ID = $("#Username_ID").val();
    var v_Fullname_ID = $("#Fullname_ID").val();
    var v_Department_ID = $("#Department_ID").val();
    var v_Position_ID = $("#Position_ID").val();
    // var v_Create_Date_ID = $("#Create_Date_ID").val();
    if (!v_Email_ID || v_Email_ID.length < 6 || v_Email_ID.length > 50) {
      // show error message
      alert("Email name must be from 6 to 50 characters!");
      return false;
    }
    if (
      !v_Username_ID ||
      v_Username_ID.length < 6 ||
      v_Username_ID.length > 50
    ) {
      // show error message
      alert("Username name must be from 6 to 50 characters!");
      return false;
    }
    if (
      !v_Fullname_ID ||
      v_Fullname_ID.length < 6 ||
      v_Fullname_ID.length > 50
    ) {
      // show error message
      alert("Fullname name must be from 6 to 50 characters!");
      return false;
    }
    if (!v_Department_ID || v_Department_ID == "--Select a Department--") {
      // show error message
      alert("Pls choose Department!");
      return false;
    }
    if (!v_Position_ID || v_Position_ID == "--Select a Position--") {
      // show error message
      alert("Pls choose Position!");
      return false;
    }
    // Lấy ra ID của Department khi người dùng lựa chọn phòng ban
    for (let index = 0; index < listDepartment.length; index++) {
      if (listDepartment[index].DepartmentName == v_Department_ID) {
        var depID = listDepartment[index].DepartmentID;
      }
    }
    // Lấy ra ID của Position khi người dùng lựa chọn Position
    for (let index = 0; index < listPosition.length; index++) {
      if (listPosition[index].PositionName == v_Position_ID) {
        var posID = listPosition[index].PositionID;
      }
    }

    // listAccount.push(account)

    // $.ajax({
    //   url: "http://localhost:8080/api/v1/accounts/",
    //   type: "POST",
    //   data: account,
    //   success: function (result) {
    //     if (result == undefined || result == null) {
    //       alert("Error when loading data");
    //       return;
    //     }
    //     alert("Create Completed ! ");
    //     currentPage = totalPages;
    //     getListEmployees();
    //   },
    // });
    $.ajax({
      url: "http://localhost:8080/api/v1/accounts/EmailExists/" + v_Email_ID,
      type: "GET",
      contentType: "application/json",
      dataType: "json", // datatype return
      beforeSend: function (xhr) {
        xhr.setRequestHeader(
          "Authorization",
          "Basic " +
            btoa(
              localStorage.getItem("USERNAME") +
                ":" +
                localStorage.getItem("PASSWORD")
            )
        );
      },
      success: function (data, textStatus, xhr) {
        if (data) {
          alert("Email đã tồn tại trên hệ thống");
          return false;
        } else {
          // Check Username đã có trên hệ thống hay chưa?
          $.ajax({
            url:
              "http://localhost:8080/api/v1/accounts/UsernameExists/" +
              v_Username_ID,
            type: "GET",

            contentType: "application/json",
            dataType: "json", // datatype return
            beforeSend: function (xhr) {
              xhr.setRequestHeader(
                "Authorization",
                "Basic " +
                  btoa(
                    localStorage.getItem("USERNAME") +
                      ":" +
                      localStorage.getItem("PASSWORD")
                  )
              );
            },
            success: function (data, textStatus, xhr) {
              if (data) {
                alert("Username đã tồn tại trên hệ thống");
                return false;
              } else {
                var account = {
                  email: v_Email_ID,
                  username: v_Username_ID,
                  fullname: v_Fullname_ID,
                  departmentID: depID,
                  positionID: posID,
                  //'CreateDate' : v_Create_Date_ID
                };
                // Add account tới MOCK API
                $.ajax({
                  url: "http://localhost:8080/api/v1/accounts/",

                  type: "POST",
                  data: JSON.stringify(account), // body

                  contentType: "application/json", // type of body (json, xml, text)
                  // dataType: 'json', // datatype return
                  beforeSend: function (xhr) {
                    xhr.setRequestHeader(
                      "Authorization",
                      "Basic " +
                        btoa(
                          localStorage.getItem("USERNAME") +
                            ":" +
                            localStorage.getItem("PASSWORD")
                        )
                    );
                  },

                  success: function (data, textStatus, xhr) {
                    currentPage = totalPages;
                    alert("Create Completed ! ");
                    getListEmployees();
                  },

                  error(jqXHR, textStatus, errorThrown) {
                    alert("Error when loading data");
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                  },
                });
              }
            },

            error(jqXHR, textStatus, errorThrown) {
              console.log(jqXHR);

              console.log(textStatus);
              console.log(errorThrown);
            },
          });
        }
      },
      error(jqXHR, textStatus, errorThrown) {
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });

    // showAccount()
    return false;
  });
});

function showAccount() {
  $("#Result_TB").empty();
  for (var index = 0; index < listAccount.length; index++) {
    $("#Result_TB").append(`
        <tr>
            <th>${listAccount[index].AccountID}</th>
            <th>${listAccount[index].Email}</th>
            <th>${listAccount[index].Username}</th>
            <th>${listAccount[index].Fullname}</th>
            <th>${listAccount[index].Department}</th>
            <th>${listAccount[index].Position}</th> 
            <th>${listAccount[index].CreateDate}</th>
             <th><button class="btn btn-warning" onclick="editAccount(${index})">Edit</button></th>
            <th><button class="btn btn-warning" onclick="deleteAccount(${index})">Delete</button></th>
        </tr>
        `);
  }
}

function deleteAccount(Index) {
  var v_del_ID = listAccount[Index].AccountID;
  console.log(v_del_ID);
  var confirm_del = confirm("Bạn có chắc chắn muốn xóa Account này không");
  if (confirm_del) {
    // listAccount.splice(Index, 1)
    // showAccount()
    // $.ajax({
    //   url: "http://localhost:8080/api/v1/accounts/" + v_del_ID,
    //   type: "DELETE",
    //   success: function (result) {
    //     if (result == undefined || result == null) {
    //       alert("Error when loading data");
    //       return;
    //     }
    //     alert("Delete Completed ! ");
    //     resetPaging();
    //     getListEmployees();
    //   },
    // });
    $.ajax({
      url: "http://localhost:8080/api/v1/accounts/" + v_del_ID,
      type: "DELETE",
      beforeSend: function (xhr) {
        xhr.setRequestHeader(
          "Authorization",
          "Basic " +
            btoa(
              localStorage.getItem("USERNAME") +
                ":" +
                localStorage.getItem("PASSWORD")
            )
        );
      },
      success: function (result) {
        // error
        if (result == undefined || result == null) {
          alert("Error when loading data");
          return;
        }
        // success
        resetPaging();
        getListEmployees();
      },
    });
  } else {
    return;
  }
}

function editAccount(Index) {
  $("#ID_ID").val(listAccount[Index].AccountID);
  $("#Email_ID").val(listAccount[Index].Email);
  $("#Username_ID").val(listAccount[Index].Username);
  $("#Fullname_ID").val(listAccount[Index].Fullname);
  $("#Department_ID").val(listAccount[Index].Department);
  $("#Position_ID").val(listAccount[Index].Position);
  $("#Create_Date_ID").val(listAccount[Index].CreateDate);

  $("#ID_ID").attr("disabled", "disabled");
  $("#Email_ID").attr("disabled", "disabled");
  $("#Username_ID").attr("disabled", "disabled");

  $("#update_btn").click(function () {
    var v_ID_ID = $("#ID_ID").val();
    // var v_Email_ID = $("#Email_ID").val();
    // var v_Username_ID = $("#Username_ID").val();
    var v_Fullname_ID = $("#Fullname_ID").val();
    var v_Department_ID = $("#Department_ID").val();
    var v_Position_ID = $("#Position_ID").val();
    // var v_Create_Date_ID = $("#Create_Date_ID").val();

    // Lấy ra ID của Department khi người dùng lựa chọn phòng ban
    for (let index = 0; index < listDepartment.length; index++) {
      if (listDepartment[index].DepartmentName == v_Department_ID) {
        var depID = listDepartment[index].DepartmentID;
      }
    }
    // Lấy ra ID của Position khi người dùng lựa chọn Position
    for (let index = 0; index < listPosition.length; index++) {
      if (listPosition[index].PositionName == v_Position_ID) {
        var posID = listPosition[index].PositionID;
      }
    }
    if (
      !v_Fullname_ID ||
      v_Fullname_ID.length < 6 ||
      v_Fullname_ID.length > 50
    ) {
      // show error message
      alert("Fullname name must be from 6 to 50 characters!");
      return false;
    }
    if (!v_Department_ID || v_Department_ID == "--Select a Department--") {
      // show error message
      alert("Pls choose Department!");
      return false;
    }
    if (!v_Position_ID || v_Position_ID == "--Select a Position--") {
      // show error message
      alert("Pls choose Position!");
      return false;
    }
    var account = {
      //'Email' : v_Email_ID,
      //'Username': v_Username_ID,
      fullname: v_Fullname_ID,
      departmentID: depID,
      positionID: posID,
      //'CreateDate' : v_Create_Date_ID
    };

    // $.ajax({
    //   url: "http://localhost:8080/api/v1/accounts/" + v_ID_ID,
    //   type: "PUT",
    //   data: account,
    //   success: function (result) {
    //     if (result == undefined || result == null) {
    //       alert("Error when loading date ");
    //       return;
    //     }
    //     alert("Update Completed !! ");
    //     currentPage = totalPages;
    //     getListEmployees();
    //   },
    // });
    $.ajax({
      url: "http://localhost:8080/api/v1/accounts/" + v_ID_ID,
      type: "PUT",
      data: JSON.stringify(account), // body
      contentType: "application/json", // type of body (json, xml, text)
      beforeSend: function (xhr) {
        xhr.setRequestHeader(
          "Authorization",
          "Basic " +
            btoa(
              localStorage.getItem("USERNAME") +
                ":" +
                localStorage.getItem("PASSWORD")
            )
        );
      },

      // dataType: 'json', // datatype return
      success: function (data, textStatus, xhr) {
        alert("Update Completed !! ");
        currentPage = totalPages;
        getListEmployees();
      },
      error(jqXHR, textStatus, errorThrown) {
        alert("Error when loading data");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });
  });
}

function getListEmployees() {
  var url = "http://localhost:8080/api/v1/accounts/";
  url += "?page=" + currentPage + "&size=" + size;
  url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");
  var search = $("#input-search-department").val();
  if (search) {
    url += "&search=" + search;
  }
  // $.get(url, function (data, status) {
  //   listAccount = [];
  //   if (status == "error") {
  //     alert("Error when loading data");
  //     return;
  //   }
  //   parseData(data);
  //   showAccount();
  //   totalPages = data.totalPages;
  //   pagingTable(totalPages);
  // });
  $.ajax({
    url: url,
    type: "GET",
    contentType: "application/json",
    dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
          btoa(
            localStorage.getItem("USERNAME") +
              ":" +
              localStorage.getItem("PASSWORD")
          )
      );
    },
    success: function (data, textStatus, xhr) {
      // reset list employees
      listAccount = [];
      parseData(data);
      showAccount();
      totalPages = data.totalPages;
      // Sau khi hiển thị dữ liệu sẽ Show thêm các nút để thực hiện phân trang, tính các nút này dựa trên API totalPages được trả ra
      pagingTable(totalPages);
    },
    error(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

function parseData(data) {
  data.content.forEach(function (item) {
    var account = {
      AccountID: item.id,
      Email: item.email,
      Username: item.username,
      Fullname: item.fullname,
      Department: item.department,
      Position: item.position,
      CreateDate: item.createDate,
    };
    listAccount.push(account);
  });
}

function getListDepartment() {
  //   $.get("http://localhost:8080/api/v1/departments", function (data, status) {
  //     listDepartment = [];
  //     if (status == "error") {
  //       alert("Error when loading data");
  //       return;
  //     }
  //     data.forEach(function (item) {
  //       var department = {
  //         DepartmentID: item.id,
  //         DepartmentName: item.name,
  //       };
  //       listDepartment.push(department);
  //     });
  //     for (let index = 0; index < listDepartment.length; index++) {
  //       $("#Department_ID").append(`
  //       <option>${listDepartment[index].DepartmentName}</option>
  //       `);
  //     }
  //     showDepartment();
  //   });
  // }
  // function showDepartment() {
  //   $("#Department_ID").empty();
  //   for (var index = 0; index < listDepartment.length; index++) {
  //     $("#Department_ID").append(`
  //         <option>${listDepartment[index].DepartmentName}</option>
  //         `);
  //   }
  $.ajax({
    url: "http://localhost:8080/api/v1/departments/",
    type: "GET",
    contentType: "application/json",
    dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
          btoa(
            localStorage.getItem("USERNAME") +
              ":" +
              localStorage.getItem("PASSWORD")
          )
      );
    },
    success: function (data, textStatus, xhr) {
      // Đoạn lệnh này copy từ phần gọi Ajax theo cách không xác thực commemt bên trên xuống.
      data.forEach(function (item) {
        var department = {
          DepartmentID: item.id,
          DepartmentName: item.name,
        };
        listDepartment.push(department);
      });
      for (var index = 0; index < listDepartment.length; index++) {
        $("#Department_ID").append(
          `<option>${listDepartment[index].DepartmentName}</option>`
        );
      }
    },
    error(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

function getListPosition() {
  // $.get("http://localhost:8080/api/v1/positions", function (data, status) {
  //   listPosition = [];
  //   if (status == "error") {
  //     alert("Error when loading data");
  //     return;
  //   }
  //   data.forEach(function (item) {
  //     var position = {
  //       PositionID: item.id,
  //       PositionName: item.name,
  //     };
  //     listPosition.push(position);
  //   });
  //   for (let index = 0; index < listPosition.length; index++) {
  //     $("#Position_ID").append(`
  //     <option>${listPosition[index].PositionName}</option>
  //     `);
  //   }
  //   showPosition();
  // });
  $.ajax({
    url: "http://localhost:8080/api/v1/positions/",
    type: "GET",
    contentType: "application/json",
    dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
          btoa(
            localStorage.getItem("USERNAME") +
              ":" +
              localStorage.getItem("PASSWORD")
          )
      );
    },
    success: function (data, textStatus, xhr) {
      // Đoạn lệnh này copy từ phần gọi Ajax theo cách không xac thực commemt bên trên xuống.

      data.forEach(function (item) {
        var position = {
          PositionID: item.id,
          PositionName: item.name,
        };
        listPosition.push(position);
      });
      for (let index = 0; index < listPosition.length; index++) {
        $("#Position_ID").append(
          `<option>${listPosition[index].PositionName}</option>`
        );
      }
    },
    error(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}
// function showPosition() {
//   $("#Position_ID").empty();
//   for (var index = 0; index < listPosition.length; index++) {
//     $("#Position_ID").append(`
//         <option>${listPosition[index].PositionName}</option>
//         `);
//   }
// }

// Hàm Gen ra cá icon dùng trong phân trang
function pagingTable(pageAmount) {
  var pagingStr = "";
  // Hàm Gen nút Previous

  if (pageAmount > 1 && currentPage > 1) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="prevPaging()">Previous</a>' +
      "</li>";
  }
  // Hàm Gen nút số trang 1,2,3 ...
  for (i = 0; i < pageAmount; i++) {
    pagingStr +=
      '<li class="page-item ' +
      (currentPage == i + 1 ? "active" : "") +
      '">' +
      '<a class="page-link" onClick="changePage(' +
      (i + 1) +
      ')">' +
      (i + 1) +
      "</a>" +
      "</li>";
  }
  // Hàm Gen nút Next
  if (pageAmount > 1 && currentPage < pageAmount) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="nextPaging()">Next</a>' +
      "</li>";
  }
  $("#pagination").empty();
  $("#pagination").append(pagingStr);
}

// Hàm thực hiện khi nhấn vào các nút phân trang 1, 2, 3
function changePage(page) {
  if (page == currentPage) {
    return;
  }
  currentPage = page;
  getListEmployees();
}
// Hàm reset về trang mặc định, trang đầu tiên 1. Sử dụng khi xóa dữ liệu
function resetPaging() {
  currentPage = 1;
  size = 5;
}
// Hàm xử lý khi nhấn nút Previous
function prevPaging() {
  changePage(currentPage - 1);
}
// Hàm xử lý khi nhấn nút next
function nextPaging() {
  changePage(currentPage + 1);
}

function changeSort(field) {
  if (field == sortField) {
    isAsc = !isAsc;
  } else {
    sortField = field;
    isAsc = true;
  }
  getListEmployees();
}

function handleSearch() {
  getListEmployees();
}

// $(function () {
//   var isRememberMe = storage.getRememberMe();
//   document.getElementById("rememberMe").checked = isRememberMe;
//   if (isRememberMe) {
//     username = $("#Username_Login_id").val();
//     password = $("#Password_Login_id").val();
//   }
// });

function loginSuccess() {
  // Get username & password
  var username = $("#Email_Login_id").val();
  var password = $("#Password_Login_id").val();
  // Call API

  $.ajax({
    url: "http://localhost:8080/api/v1/login",
    type: "GET",
    contentType: "application/json",
    dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " + btoa(username + ":" + password)
      );
    },
    success: function (data, textStatus, xhr) {
      if (data.status == "NOT_ACTIVE") {
        alert("Tài khoản chưa Active, hay Active để đăng nhập ! ");
        return false;
      }
      // save data to storage
      // https://www.w3schools.com/html/html5_webstorage.asp
      localStorage.setItem("ID", data.id);
      localStorage.setItem("FULL_NAME", data.fullName);
      localStorage.setItem("USERNAME", username);
      localStorage.setItem("PASSWORD", password);
      // redirect to home page
      // https://www.w3schools.com/howto/howto_js_redirect_webpage.asp
      window.location.replace("QLNV.html");
    },
    error(jqXHR, textStatus, errorThrown) {
      if (jqXHR.status == 401) {
        alert("Kiểm tra lại thông tin!!");
      } else {
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      }
    },
  });
}
function returnPageRegister() {
  window.open("Register.html", "_self");
}
// Nhóm hàm Show Avatar
function showAvatar() {
  // Get ImgName
  var url = "http://localhost:8080/api/v1/files/image/";
  url += localStorage.getItem("ID"); // Gửi kèm id của User đăng nhập cho Backend
  $.ajax({
    url: url,
    type: "GET",
    // Kiểu dữ liệu trả về là String nên khi chuyển sang bên Frontend sẽ gọi là text.html
    contentType: "text/html", // Đổi kiểu dữ liệu text cho phù hợp với kiểu trả về là tên ảnh trong Backend
    dataType: "html", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
          btoa(
            localStorage.getItem("USERNAME") +
              ":" +
              localStorage.getItem("PASSWORD")
          )
      );
    },
    success: function (data, textStatus, xhr) {
      // Đoạn lệnh này copy từ phần gọi Ajax theo cách không xác thực commemt bên trên xuống.
      // Show Avatar, thêm thể img vào thẻ div tương ứng trong html
      $(".imgAvatar").append(
        `<img src="UploadImage/${data}" alt="No Image" style="vertical-align: middle; width: 200px; height: 200px; border-radius: 50%;">`
      );
    },
    error(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

// Nhóm hàm Upload ảnh
$("#btn_changeAvatar").click(function () {
  // Tạo đối tượng Form Data để lưu thông tin gửi đi
  var myForm = $("#form_avatar");
  var formData = new FormData(myForm[0]);
  // Set file input vào Form data trước khi gửi đi
  formData.append("image", $("#files")[0].files[0]);
  // Set id của User đăng nhập vào Form data trước khi gửi đi
  var id = $("#ID_ID").val();
  formData.append("id", id);
  console.log(formData);
  // fomrData.append('id', '4');

  $.ajax({
    url: "http://localhost:8080/api/v1/files/image",
    type: "POST",
    data: formData, // body
    processData: false,
    contentType: false, // Không để kiểu Content do đang gửi dữ liệu Formdata
    // dataType: 'json', // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
          btoa(
            localStorage.getItem("USERNAME") +
              ":" +
              localStorage.getItem("PASSWORD")
          )
      );
    },
    success: function (data, textStatus, xhr) {
      showAvatar(); // Sau khi thay đổi avatar thành công gọi lại hàm này để show lại ảnh.
    },
    error(jqXHR, textStatus, errorThrown) {
      alert("Error when loading data");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
});

// Hàm xử lý logout
function logout() {
  // Xóa các dữ liệu đã lưu trong localStorage
  localStorage.removeItem("ID");
  localStorage.removeItem("USERNAME");
  localStorage.removeItem("FULL_NAME");
  localStorage.removeItem("PASSWORD");
  // Chuyển tới trang login
  window.location.replace("Login.html");
}

// Kích hoạt qua email
// Hàm xử lý sự kiện khi click vào nút Resent Token, Ẩn hiện form gửi lại mã Token
function ResentEmailActive() {
  $("#form1").toggle();
}
//Hàm xử lý click vào nút Get Token, viết hàm để gửi lại Token
function getToken() {
  var email_id_token = $("#email_id_token").val();
  // console.log("Email nhận được: ", email_id_token);
  // Thực hiện check xem người dùng đã nhập vào Email hay chưa.
  if (email_id_token) {
    var base_URL =
      "http://localhost:8080/api/v1/accountsRegister/userRegistrationConfirmRequest/";
    base_URL += "?email=" + email_id_token;
    // Thực hiện validate Email, kiểm tra xem email có trên hệ thống hay không
    $.ajax({
      url:
        "http://localhost:8080/api/v1/accounts/EmailExists/" + email_id_token,
      type: "GET",
      contentType: "application/json",
      dataType: "json", // datatype return
      beforeSend: function (xhr) {
        xhr.setRequestHeader(
          "Authorization",
          "Basic " + btoa("Username1:123456")
        );
      },
      success: function (data, textStatus, xhr) {
        if (data) {
          // TH này email đã có trên hệ thống, sẽ thực hiện Resent Email token
          $.ajax({
            url: base_URL,
            type: "GET",
            contentType: "application/json",
            dataType: "text", // datatype return
            beforeSend: function (xhr) {
              xhr.setRequestHeader(
                "Authorization",
                "Basic " + btoa("Username1:123456")
              );
            },
            success: function (data, textStatus, xhr) {
              alert(
                "Chúng tôi đã gửi lại cho bạn email để kích hoạt, hãy Check lại."
              );
              $("#form1").hide(); // Thực hiện đóng form gửi email Token
            },
            error(jqXHR, textStatus, errorThrown) {
              console.log(jqXHR);
              console.log(textStatus);
              console.log(errorThrown);
            },
          });
        } else {
          // TH này Không có email người dùng nhập trên hệ thống
          alert("Hãy kiểm tra lại thông tin email!!!");
          return false;
        }
      },
      error(jqXHR, textStatus, errorThrown) {
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });
  } else {
    alert("Hãy nhập vào email!!");
    return false;
  }
}
