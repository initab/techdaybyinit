# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|

  config.vm.box = "bento/centos-7.1"

  config.vm.network "forwarded_port", guest: 8090, host: 8090

  config.vm.provider "virtualbox" do |vb|
    vb.memory = 2048
    vb.cpus = 2
  end

  config.vm.provision "shell", inline: <<-SHELL
    sudo yum install -y docker java-1.8.0-openjdk-devel
    sudo easy_install pip
    sudo systemctl enable docker
    sudo systemctl start docker
  SHELL

end
