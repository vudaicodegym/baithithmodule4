
    function show() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/home",
        //xử lý khi thành công
        success: function (data) {
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str += "<tr>"
                str += `<td>${data[i].name}</td>`
                str += `<td>${data[i].country.countryName}</td>`
                str += `<td>
<!--onclick="return confirm('Are you sure?')" href="/managerProduct?action=delete&&id="-->
                          <button type="button" class="btn btn-primary" style="background:#04AA6D">detail</button>
                          <button type="button" class="btn btn-primary" onclick="return confirm('areyou sure?' deleteProduct(${data[i].id}))" style="background:#ff1111">delete</button>
                          <button  onclick="showFormEdit(${data[i].id})" style="background-color: aqua" type="button" class="btn btn-primary" data-toggle="modal" data-target="#editForm">edit</button>
                        </td>\`
</td>`
                str += "</tr>"
            }
            document.getElementById("tbody").innerHTML = str;
        },
        error: function (err) {
            console.log(err)
        }
    })
}

    show();

    function deleteProduct(id){
    $.ajax({
        type: "DELETE",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/home/" + id,
        success: function () {
            show()
        },
        error: function (err) {
            console.log(err)
        }
    })
}
    function create() {
    let name = document.getElementById("name").value;
    let  area = document.getElementById(" area").value;
    let population = document.getElementById("population").value;
    let GDP = document.getElementById("GDP").value;
    let introduce = document.getElementById("introduce").value;
    let idCountry = document.getElementById("idCountry").value;

    let city  = {
    name: name,
        area: area,
        population: population,
        GDP: GDP,
        introduce: introduce,
    country: {idCountry: idCountry},
}

    $.ajax({
    type: "POST",
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
},
    url: "http://localhost:8080/home/create",
    data: JSON.stringify(city),
    //xử lý khi thành công
    success: function (data) {
    show()
},
    error: function (err) {
    console.log(err)
}
})
}
    function edit(){
        let name = document.getElementById("name").value;
        let  area = document.getElementById(" area").value;
        let population = document.getElementById("population").value;
        let GDP = document.getElementById("GDP").value;
        let introduce = document.getElementById("introduce").value;
        let idCountry = document.getElementById("idCountry").value;

        let city  = {
            name: name,
            area: area,
            population: population,
            GDP: GDP,
            introduce: introduce,
            country: {idCountry: idCountry},
}
    console.log(city);
    $.ajax({
    type: "PUT",
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
},
    url: "http://localhost:8080/home/" + id,
    data: JSON.stringify(student),
    //xử lý khi thành công
    success: function (data) {
    show()
},
    error: function (err) {
    console.log(err)
}
})
}
    function showFormEdit(id){
    $.ajax({
        type:"GET",
        url: "http://localhost:8080/home/"+id,
        success:function (data){
            document.getElementById("idEdit").value = data.id;
            document.getElementById("nameEdit").value = data.name;
            document.getElementById("dateOfBirthEdit").value = data.dateOfBirth;
            document.getElementById("emailEdit").value = data.email;
            document.getElementById("addressEdit").value = data.address;
            document.getElementById("phoneNumberEdit").value = data.phoneNumber;
            document.getElementById("idClassEdit").value = data.classroom.idClass;
        },
        error: function (err) {
            console.log(err)
        }
    })
}
    function getAllCountry(){
    $.ajax({
        type: "GET",
        url : "http://localhost:8080/home/country",
        success: function (data){
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str+= `<option value="${data[i].idClass}">${data[i].className}</option>`
            }
            document.getElementById("idCountry").innerHTML = str;
            // document.getElementById("idClassEdit").innerHTML = str;
        }
    })
}
    getAllClassroom()
